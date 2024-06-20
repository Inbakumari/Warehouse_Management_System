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
import com.example.warehouse.system.exception.StorageNotFoundByIdException;
import com.example.warehouse.system.mapper.InventoryMapper;
import com.example.warehouse.system.repository.BatchRepository;
import com.example.warehouse.system.repository.ClientRepository;
import com.example.warehouse.system.repository.InventoryRepository;
import com.example.warehouse.system.repository.StorageRespository;
import com.example.warehouse.system.requestdto.InventoryRequest;
import com.example.warehouse.system.responsedto.AddressResponse;
import com.example.warehouse.system.responsedto.ClientResponse;
import com.example.warehouse.system.responsedto.InventoryResponse;
import com.example.warehouse.system.service.InventoryService;
import com.example.warehouse.system.utility.ResponseStructure;

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
	public ResponseEntity<ResponseStructure<InventoryResponse>> updateInventoryById(
			InventoryRequest inventoryRequest, int inventoryId) {
		return  inventoryRepository.findById(inventoryId).map(inventory -> {

			inventory = inventoryRepository.save(inventoryMapper.mapToInventory(inventoryRequest, inventory));

			return  ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseStructure<InventoryResponse>()
							.setStatusCode(HttpStatus.OK.value())
							.setMessage("Inventory Updated Successfully")
							.setData(inventoryMapper.mapToInventoryResponse(inventory)));
		}).orElseThrow(()->new InventoryNotFoundByIdException("Inventory  Not Found"));
	}
}






















