package com.example.warehouse.system.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.warehouse.system.requestdto.WarehouseRequest;
import com.example.warehouse.system.responsedto.WarehouseResponse;
import com.example.warehouse.system.utility.ResponseStructure;

public interface WarehouseService {

	public ResponseEntity<ResponseStructure<WarehouseResponse>> createWarehouse(WarehouseRequest wareHouseRequest);

	public ResponseEntity<ResponseStructure<WarehouseResponse>> updateWarehouse(WarehouseRequest warehouseRequest, int warehouseId);

	public ResponseEntity<ResponseStructure<WarehouseResponse>> findWarehouse(int warehouseId);

	public ResponseEntity<ResponseStructure<List<WarehouseResponse>>> findWarehouses();

	
		
	

}
