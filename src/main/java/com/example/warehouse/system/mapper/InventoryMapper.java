package com.example.warehouse.system.mapper;

import org.springframework.stereotype.Component;

import com.example.warehouse.system.entity.Inventory;
import com.example.warehouse.system.requestdto.InventoryRequest;
import com.example.warehouse.system.responsedto.InventoryResponse;

import java.time.LocalDate;

@Component
public class InventoryMapper {

    public Inventory mapToInventory(InventoryRequest inventoryRequest, Inventory inventory) {
        inventory.setProductTitle(inventoryRequest.getProductTitle());
        inventory.setLengthInMeters(inventoryRequest.getLengthInMeters());
        inventory.setBreadthInMeters(inventoryRequest.getBreadthInMeters());
        inventory.setHeightInMeters(inventoryRequest.getHeightInMeters());
        inventory.setWeightInKG(inventoryRequest.getWeightInKG());
        inventory.setMaterialType(inventoryRequest.getMaterialType());
        inventory.setQuantity(inventoryRequest.getQuantity());
        inventory.setRestockedAt(inventory.getRestockedAt());  
        inventory.setSellerId(inventoryRequest.getSellerId());
        return inventory;
    }

    public InventoryResponse mapToInventoryResponse(Inventory inventory) {
        return InventoryResponse.builder()
                .productId(inventory.getProductId())
                .productTitle(inventory.getProductTitle())
                .lengthInMeters(inventory.getLengthInMeters())
                .breadthInMeters(inventory.getBreadthInMeters())
                .heightInMeters(inventory.getHeightInMeters())
                .materialType(inventory.getMaterialType())
                .quantity(inventory.getQuantity())
                .weightInKG(inventory.getWeightInKG())
                .restockedAt(inventory.getRestockedAt())
                .sellerId(inventory.getSellerId())
                .build();
    }

}