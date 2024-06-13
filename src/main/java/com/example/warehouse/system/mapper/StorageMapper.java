package com.example.warehouse.system.mapper;

import org.springframework.stereotype.Component;

import com.example.warehouse.system.entity.Storage;
import com.example.warehouse.system.enums.MaterialType;
import com.example.warehouse.system.requestdto.StorageRequest;
import com.example.warehouse.system.responsedto.StorageResponse;

@Component
public class StorageMapper {
	
	    public Storage mapToStorage(StorageRequest storageRequest, Storage storage) {
	        storage.setBlockName(storageRequest.getBlockName());
	        storage.setSection(storageRequest.getSection());
	        storage.setCapacityInWeight(storageRequest.getCapacityInKg());
	        storage.setMaterialTypes(storageRequest.getMaterialTypes());
	        storage.setLengthInMeters(storageRequest.getLengthInMeters());
	        storage.setBreadthInMeters(storageRequest.getBreadthInMeters());
	        storage.setHeightInMeters(storageRequest.getHeightInMeters());
	        return storage;
	    }

	    public StorageResponse mapToStorageResponse(Storage storage) {
	        return StorageResponse.builder()
	                .storageId(storage.getStorageId())
	                .blockName(storage.getBlockName())
	                .section(storage.getSection())
	                .availableArea(storage.getAvailabeArea())
	                .capacityWeight(storage.getCapacityInWeight())
	                .materialTypes(storage.getMaterialTypes())
	                .build();
	    }
	}

	

