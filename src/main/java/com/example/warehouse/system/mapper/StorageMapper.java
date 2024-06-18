package com.example.warehouse.system.mapper;

import org.springframework.stereotype.Component;

import com.example.warehouse.system.entity.Storage;
import com.example.warehouse.system.entity.StorageType;
import com.example.warehouse.system.enums.MaterialType;
import com.example.warehouse.system.requestdto.StorageRequest;
import com.example.warehouse.system.responsedto.StorageResponse;

@Component
public class StorageMapper {
	
	    public Storage mapToStorage(StorageRequest storageRequest, Storage storage) {
	        storage.setBlockName(storageRequest.getBlockName());
	        storage.setSection(storageRequest.getSection());
	       
	        storage.setMaterialTypes(storageRequest.getMaterialTypes());
	       
	        return storage;
	    }

	    public StorageResponse mapToStorageResponse(Storage storage) {
	        return StorageResponse.builder()
	                .storageId(storage.getStorageId())
	                .blockName(storage.getBlockName())
	                .section(storage.getSection())
	                .availableArea(storage.getAvailabeArea())
	                .capacityInKg(storage.getStorageType().getCapacityInKg())
	                .materialTypes(storage.getMaterialTypes())
	                .build();
	    }
	}

	

