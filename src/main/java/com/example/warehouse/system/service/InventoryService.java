package com.example.warehouse.system.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.warehouse.system.entity.Inventory;
import com.example.warehouse.system.requestdto.InventoryRequest;
import com.example.warehouse.system.responsedto.InventoryResponse;
import com.example.warehouse.system.utility.ResponseStructure;

public interface InventoryService {

	ResponseEntity<ResponseStructure<InventoryResponse>> createInventory(InventoryRequest inventoryRequest,int storageId,int clientId);

	ResponseEntity<ResponseStructure<InventoryResponse>> findInventoryById(int inventoryId);

	ResponseEntity<ResponseStructure<List<InventoryResponse>>> findAllInventorys();

}
