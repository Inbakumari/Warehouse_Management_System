package com.example.warehouse.system.serviceimpl;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.warehouse.system.entity.Client;
import com.example.warehouse.system.entity.Inventory;
import com.example.warehouse.system.entity.Storage;
import com.example.warehouse.system.exception.ClientNotFoundByIdException;
import com.example.warehouse.system.exception.StorageNotFoundByIdException;
import com.example.warehouse.system.mapper.InventoryMapper;
import com.example.warehouse.system.repository.ClientRepository;
import com.example.warehouse.system.repository.InventoryRepository;
import com.example.warehouse.system.repository.StorageRespository;
import com.example.warehouse.system.requestdto.InventoryRequest;
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

	@Override
	public ResponseEntity<ResponseStructure<InventoryResponse>> createInventory(InventoryRequest inventoryRequest,
			int storageId, int clientId) {
		Storage storage = storageRepository.findById(storageId)
				.orElseThrow(() -> new StorageNotFoundByIdException("No Storage found for the Id"));
				
				Client client = clientRepository.findById(clientId)
				.orElseThrow(() -> new ClientNotFoundByIdException("No client found for the id"));
				
				Inventory inventory = inventoryMapper.mapToInventory(inventoryRequest, new Inventory());
				inventory.setClient(client);
				inventory.setRestockedAt(LocalDate.now());
				storage.getInventories().add(inventory);
				
				double wholeWeight = inventory.getWeightInKG()*inventory.getQuantity();
				double area = inventory.getBreadthInMeters()*inventory.getHeightInMeters()*inventory.getLengthInMeters();
				
				storage.setMaxAdditionalWeight(storage.getMaxAdditionalWeight()-wholeWeight);
				storage.setAvailabeArea(storage.getAvailabeArea()-area);
				storage.setSellerId(inventory.getSellerId());
				
				
				inventory = inventoryRepository.save(inventory);
				storageRepository.save(storage);
				
				return ResponseEntity.status(HttpStatus.CREATED)
						.body(new ResponseStructure<InventoryResponse>()
								.setData(inventoryMapper.mapToInventoryResponse(inventory))
								.setStatusCode(HttpStatus.CREATED.value())
								.setMessage("Inventory Created"));
				
				
			
		}
}
	