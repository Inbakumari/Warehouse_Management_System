package com.example.warehouse.system.serviceimpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.warehouse.system.entity.Batch;
import com.example.warehouse.system.entity.Client;
import com.example.warehouse.system.entity.Inventory;
import com.example.warehouse.system.entity.Storage;
import com.example.warehouse.system.exception.AddressNotFoundByIdException;
import com.example.warehouse.system.exception.ClientNotFoundByIdException;
import com.example.warehouse.system.exception.InventoryNotFoundByIdException;
import com.example.warehouse.system.exception.SpaceOrWeightNotAvailableException;
import com.example.warehouse.system.exception.StorageNotFoundByIdException;
import com.example.warehouse.system.mapper.BatchMapper;
import com.example.warehouse.system.mapper.InventoryMapper;
import com.example.warehouse.system.repository.BatchRepository;
import com.example.warehouse.system.repository.ClientRepository;
import com.example.warehouse.system.repository.InventoryRepository;
import com.example.warehouse.system.repository.StorageRespository;
import com.example.warehouse.system.requestdto.InventoryRequest;
import com.example.warehouse.system.responsedto.AddressResponse;
import com.example.warehouse.system.responsedto.BatchResponse;
import com.example.warehouse.system.responsedto.ClientResponse;
import com.example.warehouse.system.responsedto.InventoryResponse;
import com.example.warehouse.system.service.InventoryService;
import com.example.warehouse.system.utility.ResponseStructure;

import jakarta.validation.Valid;

@Service
public class InventoryServiceImpl implements InventoryService {


	@Autowired
	private InventoryMapper inventoryMapper;

	@Autowired
	private InventoryRepository inventoryRepository;

	@Autowired
	private StorageRespository storageRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private BatchRepository batchRepository;
	
	@Autowired
	
	private BatchMapper batchMapper;

	@Override
	public ResponseEntity<ResponseStructure<InventoryResponse>> createInventory(InventoryRequest inventoryRequest,
			int storageId, int quantity,int clientId) 
	{
		Storage storage = storageRepository.findById(storageId).orElseThrow(() -> new StorageNotFoundByIdException("No Storage found for the Id"));

		Client client=clientRepository.findById(clientId).orElseThrow(() -> new ClientNotFoundByIdException("Client not Found For The Given Id"));
		Inventory inventory = inventoryRepository.save(inventoryMapper.mapToInventory(inventoryRequest, new Inventory()));
		inventory.setRestockedAt(LocalDate.now());
		inventory.setClient(client);
		Batch batch=new Batch();

		storage.setMaxAdditionalWeight(storage.getMaxAdditionalWeight()-inventory.getWeightInKG()*quantity);
		storage.setAvailabeArea(storage.getAvailabeArea()-inventory.getLengthInMeters()*inventory.getBreadthInMeters()*inventory.getHeightInMeters());
		storage.setSellerId(inventory.getSellerId());


		inventory = inventoryRepository.save(inventory);
		storage=storageRepository.save(storage);

		batch.setInventory(inventory);
		batch.setStorage(storage);
		batch.setQuantity(quantity);
		batch=batchRepository.save(batch);

		List<Batch> batches=new ArrayList<Batch>();
		batches.add(batch);


		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseStructure<InventoryResponse>()
						.setData(inventoryMapper.mapToInventoryResponse(inventory,batches))
						.setStatusCode(HttpStatus.CREATED.value())
						.setMessage("Inventory Created"));



	}

	@Override
	public ResponseEntity<ResponseStructure<InventoryResponse>> findInventoryById(int inventoryId) {
		return inventoryRepository.findById(inventoryId).map(inventory -> {

			return ResponseEntity
					.status(HttpStatus.FOUND)
					.body(new ResponseStructure<InventoryResponse>()
							.setStatusCode(HttpStatus.FOUND.value())
							.setMessage("Inventory Found Succesfully")
							.setData(inventoryMapper.mapToInventoryResponse(inventory)));
		}).orElseThrow(() -> new InventoryNotFoundByIdException("Inventory Not Found By The Given Id"));
	}

	@Override
	public ResponseEntity<ResponseStructure<List<InventoryResponse>>> findAllInventorys() {
		List<InventoryResponse> inventoryResponse=inventoryRepository.findAll().stream().map(inventory -> inventoryMapper.mapToInventoryResponse(inventory))
				.toList();

		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseStructure<List<InventoryResponse>>()
						.setStatusCode(HttpStatus.OK.value())
						.setMessage("Found All Inventories Successfully")
						.setData(inventoryResponse));
	}

	@Override
	public ResponseEntity<ResponseStructure<InventoryResponse>> updateInventory( @Valid InventoryRequest inventoryRequest,
			int inventoryId,int storageId) 
	{

		return inventoryRepository.findById(inventoryId).map(inventory -> {
			Storage storage=storageRepository.findById(storageId).orElseThrow(() -> new StorageNotFoundByIdException("Storage Not Found"));
			List<Batch> batches=batchRepository.findByInventoryAndStorage(inventory, storage);
			int totalQuantity=0;
			for(Batch batch: batches)
			{
				totalQuantity=totalQuantity+batch.getQuantity();
			}

			double oldWeightInKg=inventory.getWeightInKG();
			double oldLength=inventory.getLengthInMeters();
			double oldBreadth=inventory.getBreadthInMeters();
			double oldHeight=inventory.getHeightInMeters();

			double originalWeight=oldWeightInKg*totalQuantity;
			double originalArea=oldBreadth*oldHeight*oldLength;

			inventoryMapper.mapToInventory(inventoryRequest, inventory);

			double newWeight=inventory.getWeightInKG()*totalQuantity;
			double newArea=inventory.getBreadthInMeters()*inventory.getHeightInMeters()*inventory.getLengthInMeters();

			if(oldLength!=inventory.getLengthInMeters()|| oldBreadth!=inventory.getBreadthInMeters()||oldHeight!=inventory.getHeightInMeters() || oldWeightInKg != inventory.getWeightInKG())
			{
				if(storage.getAvailabeArea()>0 && storage.getMaxAdditionalWeight() >0)
				{
					storage.setMaxAdditionalWeight(storage.getMaxAdditionalWeight() + (originalWeight- newWeight));
					storage.setAvailabeArea(storage.getAvailabeArea()+ (originalArea- newArea));
				}
				
			}
			
			Batch batch=new Batch();

			storageRepository.save(storage);
			
			batch.setInventory(inventory);
			batch.setStorage(storage);
			inventory=inventoryRepository.save(inventory);
			batch=batchRepository.save(batch);
			batches.add(batch);
			return  ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseStructure<InventoryResponse>()
							.setStatusCode(HttpStatus.OK.value())
							.setMessage("Inventory Updated Successfully")
							.setData(inventoryMapper.mapToInventoryResponse(inventory,batches)));
		}).orElseThrow(()->new InventoryNotFoundByIdException("Failed To Update The Inventory"));


	}

	@Override
	public ResponseEntity<ResponseStructure<BatchResponse>> updateQuantityUsingBatch(int storageId, int inventoryId, int quantity) {
		return  inventoryRepository.findById(inventoryId).map(inventory -> {
			Storage storage = storageRepository.findById(storageId).orElseThrow(() -> new StorageNotFoundByIdException("Storage Not Found"));
			Batch batch = new Batch();
			
			if(batch.getQuantity()!=quantity)
			{
				batch.setQuantity(quantity);
				inventory.setRestockedAt(LocalDate.now());
			}
			
			storageRepository.save(storage);
			batch.setInventory(inventory);
			batch.setStorage(storage);
			inventory=inventoryRepository.save(inventory);
			batch=batchRepository.save(batch);
			return  ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseStructure<BatchResponse>()
							.setStatusCode(HttpStatus.OK.value())
							.setMessage("Quantity Updated Successfully")
							.setData(batchMapper.mapToBatchResponse(batch))); 
		}).orElseThrow(() -> new InventoryNotFoundByIdException("Failed To Update Quantity"));
	}


}

























