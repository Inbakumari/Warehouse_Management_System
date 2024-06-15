package com.example.warehouse.system.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.warehouse.system.entity.StorageType;
import com.example.warehouse.system.entity.Warehouse;
import com.example.warehouse.system.exception.StorageNotFoundByIdException;
import com.example.warehouse.system.exception.StorageTypeNotFoundByIdException;
import com.example.warehouse.system.mapper.StorageTypeMapper;
import com.example.warehouse.system.repository.StorageTypeRepository;
import com.example.warehouse.system.requestdto.StorageTypeRequest;
import com.example.warehouse.system.responsedto.StorageResponse;
import com.example.warehouse.system.responsedto.StorageTypeResponse;
import com.example.warehouse.system.responsedto.WarehouseResponse;
import com.example.warehouse.system.service.StorageTypeService;
import com.example.warehouse.system.utility.ResponseStructure;

@Service
public class StorageTypeServiceImpl implements StorageTypeService  {
	
	@Autowired
	private StorageTypeRepository storageTypeRepository;
	
	@Autowired
	private StorageTypeMapper storageTypeMapper;

	@Override
	public ResponseEntity<ResponseStructure<StorageTypeResponse>> createStorageType(StorageTypeRequest storageTypeRequest) {
		
		
		StorageType storageType= storageTypeRepository.save(storageTypeMapper.mapToStorageType(storageTypeRequest, new StorageType()));
		storageType.setUnitsAvailable(0);
		storageTypeRepository.save(storageType);

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseStructure<StorageTypeResponse>()
						.setStatusCode(HttpStatus.CREATED.value())
						.setMessage("StorageType created")
						.setData(storageTypeMapper.mapToStorageTypeResponse(storageType)));	
	}

	@Override
	public ResponseEntity<ResponseStructure<StorageTypeResponse>> updateStorageTypeById(StorageTypeRequest storageTypeRequest, int storageTypeId) {
	    return storageTypeRepository.findById(storageTypeId).map(storageType -> {
	        storageType = storageTypeMapper.mapToStorageType(storageTypeRequest, storageType);
	        storageTypeRepository.save(storageType);
	        StorageTypeResponse storageTypeResponse = storageTypeMapper.mapToStorageTypeResponse(storageType);
	        
	        ResponseStructure<StorageTypeResponse> responseStructure = new ResponseStructure<>();
	        responseStructure.setStatusCode(HttpStatus.OK.value());
	        responseStructure.setMessage("StorageType Updated Successfully");
	        responseStructure.setData(storageTypeResponse);
	        
	        return ResponseEntity.status(HttpStatus.OK).body(responseStructure);
	    }).orElseThrow(() -> new StorageTypeNotFoundByIdException("StorageType Not Found"));
	}


}
	
