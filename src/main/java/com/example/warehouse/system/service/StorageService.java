package com.example.warehouse.system.service;

import org.springframework.http.ResponseEntity;

import com.example.warehouse.system.requestdto.StorageRequest;
import com.example.warehouse.system.responsedto.StorageResponse;
import com.example.warehouse.system.utility.ResponseStructure;
import com.example.warehouse.system.utility.SimpleStructure;

public interface StorageService {

	ResponseEntity<SimpleStructure<String>> createStorage(StorageRequest storageRequest, int wareHouseId,
			int noOfStorageUnits,int storageTypeId);

	ResponseEntity<ResponseStructure<StorageResponse>> updateStorage(StorageRequest storageRequest, int storageId);

	ResponseEntity<ResponseStructure<StorageResponse>> findByFirstStorage(double capacityInKg, double lengthInMeters,
			double breadthInMeters, double heightInMeters);


}
