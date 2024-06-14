package com.example.warehouse.system.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.warehouse.system.entity.Storage;
import com.example.warehouse.system.entity.Warehouse;
import com.example.warehouse.system.exception.StorageNotFoundByIdException;
import com.example.warehouse.system.exception.WarehouseNotFoundByIdException;
import com.example.warehouse.system.mapper.StorageMapper;
import com.example.warehouse.system.repository.StorageRespository;
import com.example.warehouse.system.repository.WareHouseRepository;
import com.example.warehouse.system.requestdto.StorageRequest;
import com.example.warehouse.system.responsedto.StorageResponse;
import com.example.warehouse.system.responsedto.WarehouseResponse;
import com.example.warehouse.system.service.StorageService;
import com.example.warehouse.system.utility.ResponseStructure;
import com.example.warehouse.system.utility.SimpleStructure;

@Service
public class StorageServiceImpl implements StorageService {

	@Autowired

	private StorageRespository storageRespository;

	@Autowired

	private StorageMapper storageMapper;

	@Autowired
	private WareHouseRepository wareHouseRepository;

	@Override
	public ResponseEntity<SimpleStructure<String>> createStorage(StorageRequest storageRequest, int wareHouseId,
	        int noOfStorageUnits) {
	    Warehouse warehouse = wareHouseRepository.findById(wareHouseId)
	            .orElseThrow(() -> new WarehouseNotFoundByIdException("Warehouse not Found"));

	    List<Storage> storages = new ArrayList<>();
	    while (noOfStorageUnits > 0) {
	        Storage storage = storageMapper.mapToStorage(storageRequest, new Storage());
	        storage.setWarehouse(warehouse);
	        storage.setAvailabeArea(storageRequest.getLengthInMeters() * storageRequest.getBreadthInMeters() * storageRequest.getHeightInMeters());
	        storage.setCapacityInWeight(storageRequest.getCapacityInKg());
	        storage.setMaxAdditionalWeight(storageRequest.getMaxAdditionalWeight());
	        warehouse.setTotalCapacity(storageRequest.getCapacityInKg()*noOfStorageUnits+warehouse.getTotalCapacity());
	        storages.add(storage);
	        noOfStorageUnits--;
	    }

	    storageRespository.saveAll(storages);
	    wareHouseRepository.save(warehouse);

	    return ResponseEntity.status(HttpStatus.CREATED)
	            .body(new SimpleStructure<String>()
	                    .setStatus(HttpStatus.CREATED.value())
	                    .setMessage("Storage created"));
	}

	@Override
	public ResponseEntity<ResponseStructure<StorageResponse>> updateStorage(StorageRequest storageRequest,int storageId) {
		
	return storageRespository.findById(storageId).map(storage -> {
		storage=storageMapper.mapToStorage(storageRequest, storage);
		storageRespository.save(storage);
	
		storageRespository.save(storage);
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseStructure<StorageResponse>()
						.setStatusCode(HttpStatus.OK.value())
						.setMessage("Storage Updated Successfully")
						.setData(storageMapper.mapToStorageResponse(storage)));
	}).orElseThrow(() -> new StorageNotFoundByIdException("Stroage Not Found"));
}
}
	





























