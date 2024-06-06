package com.example.warehouse.system.serviceimpl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.warehouse.system.entity.Warehouse;
import com.example.warehouse.system.requestdto.AdminRequest;
import com.example.warehouse.system.service.WarehouseService;
import com.example.warehouse.system.utility.ResponseStructure;

@Service
public class WarehouseServiceImpl implements WarehouseService {

	@Override
	public ResponseEntity<ResponseStructure<Warehouse>> saveWarehouse(AdminRequest adminRequest) {
		
		return null;
	}

}
