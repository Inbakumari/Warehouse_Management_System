package com.example.warehouse.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.warehouse.system.entity.WareHouse;
import com.example.warehouse.system.responsedto.WareHouseResponse;
import com.example.warehouse.system.service.WareHouseService;
import com.example.warehouse.system.utility.ResponseStructure;



@RestController
@RequestMapping("/api/v1")
public class WareHouseController {

	@Autowired
	private WareHouseService wareHouseService;


	@PostMapping("/warehouses")
	@PreAuthorize("hasAuthority('CREATE_WAREHOUSE')")  //to allow only those who have the reqrd authority will be allowed to access the resources
	public ResponseEntity<ResponseStructure<WareHouseResponse>>	createWareHouse(@RequestBody WareHouse wareHouseRequest)
	{
		return  wareHouseService.createWarehouse(wareHouseRequest);
	}
}