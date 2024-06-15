package com.example.warehouse.system.mapper;

import org.springframework.stereotype.Component;

import com.example.warehouse.system.entity.Storage;
import com.example.warehouse.system.entity.StorageType;
import com.example.warehouse.system.requestdto.StorageTypeRequest;
import com.example.warehouse.system.responsedto.StorageTypeResponse;

@Component
public class StorageTypeMapper {


	public StorageType mapToStorageType(StorageTypeRequest storageTypeRequest, StorageType storageType)
	{
		storageType.setLengthInMeters(storageTypeRequest.getLengthInMeters());
		storageType.setBreadthInMeters(storageTypeRequest.getBreadthInMeters());
		storageType.setHeightInMeters(storageTypeRequest.getHeightInMeters());
		storageType.setCapacityInKg(storageTypeRequest.getCapacityInKg());
		return storageType;
	}


	public StorageTypeResponse MapToStorageTypeResponse(StorageType storageType)
	{
		return StorageTypeResponse.builder()

				.storageTypeId(storageType.getStorageTypeId())
				.lengthInMeters(storageType.getLengthInMeters())
				.breadthInMeters(storageType.getBreadthInMeters())
				.heightInMeters(storageType.getHeightInMeters())
				.capacityInKg(storageType.getCapacityInKg())
				.unitsAvailable(storageType.getUnitsAvailable())
				.build();
	}

}
