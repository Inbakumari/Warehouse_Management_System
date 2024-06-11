package com.example.warehouse.system.service;

import org.springframework.http.ResponseEntity;

import com.example.warehouse.system.entity.WareHouse;
import com.example.warehouse.system.requestdto.WareHouseRequest;
import com.example.warehouse.system.responsedto.WareHouseResponse;
import com.example.warehouse.system.utility.ResponseStructure;

public interface WareHouseService {

	public ResponseEntity<ResponseStructure<WareHouseResponse>> createWarehouse(WareHouse wareHouseRequest);
		
	

}
