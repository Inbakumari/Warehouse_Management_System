package com.example.warehouse.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.warehouse.system.entity.Inventory;
import com.example.warehouse.system.requestdto.InventoryRequest;
import com.example.warehouse.system.responsedto.InventoryResponse;
import com.example.warehouse.system.service.InventoryService;
import com.example.warehouse.system.utility.ResponseStructure;

@RestController
@RequestMapping("/api/v1")
public class InventoryController {
	
	@Autowired
	private InventoryService inventoryService;
	
	
	@PostMapping("/inventories/{storageId}/{clientId}")
	
	public ResponseEntity<ResponseStructure<InventoryResponse>> createInventory(@RequestBody InventoryRequest inventoryRequest, @PathVariable int storageId, @PathVariable int clientId)
	{
		return inventoryService.createInventory(inventoryRequest,storageId,clientId);
	}

}
