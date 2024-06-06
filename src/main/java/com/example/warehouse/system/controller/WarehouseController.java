package com.example.warehouse.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.warehouse.system.entity.Warehouse;
import com.example.warehouse.system.requestdto.AdminRequest;
import com.example.warehouse.system.service.WarehouseService;
import com.example.warehouse.system.utility.ResponseStructure;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/v1")
public class WarehouseController {
	
	//@Autowired
	
	//private WarehouseService warehouseService;
	
	
	@PostMapping("/warehouses")
	public String saveWarehouse(@RequestBody AdminRequest adminRequest)
	{
		return "Warehouse Created";
	}

}
