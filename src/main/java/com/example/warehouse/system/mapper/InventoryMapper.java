package com.example.warehouse.system.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.warehouse.system.entity.Batch;
import com.example.warehouse.system.entity.Inventory;
import com.example.warehouse.system.repository.InventoryRepository;
import com.example.warehouse.system.requestdto.InventoryRequest;
import com.example.warehouse.system.responsedto.BatchResponse;
import com.example.warehouse.system.responsedto.InventoryResponse;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class InventoryMapper {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private BatchMapper batchMapper;

    public Inventory mapToInventory(InventoryRequest inventoryRequest, Inventory inventory) {
        inventory.setProductTitle(inventoryRequest.getProductTitle());
        inventory.setLengthInMeters(inventoryRequest.getLengthInMeters());
        inventory.setBreadthInMeters(inventoryRequest.getBreadthInMeters());
        inventory.setHeightInMeters(inventoryRequest.getHeightInMeters());
        inventory.setWeightInKG(inventoryRequest.getWeightInKG());
        inventory.setMaterialTypes(inventoryRequest.getMaterialTypes());
        inventory.setRestockedAt(inventory.getRestockedAt());  
        inventory.setSellerId(inventoryRequest.getSellerId());
        return inventory;
    }

    public InventoryResponse mapToInventoryResponse(Inventory inventory) {
        return InventoryResponse.builder()
                .productId(inventory.getProductId())
                .productTitle(inventory.getProductTitle())
                .weightInKg(inventory.getWeightInKG())
                .materialTypes(inventory.getMaterialTypes())
                .restockedAt(inventory.getRestockedAt())
                .sellerId(inventory.getSellerId())
                .build();
            
    }

    public InventoryResponse mapToInventoryResponse(Inventory inventory, List<Batch> batches) {
        List<BatchResponse> batchResponses = batches.stream()
                .map(batch -> batchMapper.mapToBatchResponse(batch))
                .collect(Collectors.toList());
        InventoryResponse inventoryResponse = mapToInventoryResponse(inventory);
        inventoryResponse.setBatches(batchResponses);
        return inventoryResponse;
    }
}
