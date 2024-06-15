package com.example.warehouse.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.warehouse.system.requestdto.StorageTypeRequest;
import com.example.warehouse.system.responsedto.StorageTypeResponse;
import com.example.warehouse.system.service.StorageTypeService;
import com.example.warehouse.system.utility.ResponseStructure;

@RestController
@RequestMapping("/api/v1")
public class StorageTypeController {
	
	@Autowired
	private StorageTypeService storageTypeService;
	
	
	@PostMapping("/storagetypes")
	
	public ResponseEntity<ResponseStructure<StorageTypeResponse>> createStorageType(@RequestBody StorageTypeRequest storageTypeRequest)
	{
		return storageTypeService.createStorageType(storageTypeRequest);
	}

}
