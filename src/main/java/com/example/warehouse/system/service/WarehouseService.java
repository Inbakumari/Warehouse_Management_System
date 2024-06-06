package com.example.warehouse.system.service;

import org.springframework.http.ResponseEntity;

import com.example.warehouse.system.entity.Warehouse;
import com.example.warehouse.system.requestdto.AdminRequest;
import com.example.warehouse.system.utility.ResponseStructure;

public interface WarehouseService {

	public ResponseEntity<ResponseStructure<Warehouse>> saveWarehouse(AdminRequest adminRequest); 
		
	

}
