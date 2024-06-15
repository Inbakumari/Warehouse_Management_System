package com.example.warehouse.system.service;

import org.springframework.http.ResponseEntity;

import com.example.warehouse.system.requestdto.StorageTypeRequest;
import com.example.warehouse.system.responsedto.StorageTypeResponse;
import com.example.warehouse.system.utility.ResponseStructure;

public interface StorageTypeService {

	ResponseEntity<ResponseStructure<StorageTypeResponse>> createStorageType(StorageTypeRequest storageTypeRequest);

	ResponseEntity<ResponseStructure<StorageTypeResponse>> updateStorageTypeById(StorageTypeRequest storageTypeRequest,
			int storageTypeId);

}
