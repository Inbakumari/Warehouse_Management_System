package com.example.warehouse.system.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.warehouse.system.entity.Batch;
import com.example.warehouse.system.responsedto.BatchResponse;

@Component
public class BatchMapper {
	
	@Autowired
	
	private StorageMapper storageMapper;
	
	
	public BatchResponse mapToBatchResponse(Batch batch)
	{
	return BatchResponse.builder()
			.batchId(batch.getBatchId())
			.quantity(batch.getQuantity())
			.storage((storageMapper.mapToStorageResponse(batch.getStorage())))
			.build();
			

}
}
