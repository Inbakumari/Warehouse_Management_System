package com.example.warehouse.system.mapper;

import org.springframework.stereotype.Component;

import com.example.warehouse.system.entity.Warehouse;
import com.example.warehouse.system.requestdto.WarehouseRequest;
import com.example.warehouse.system.responsedto.WarehouseResponse;


@Component
public class WareHouseMapper {

	public Warehouse mapToWarehouse(WarehouseRequest warehouseRequest, Warehouse warehouse) {
        warehouse.setName(warehouseRequest.getName());
        return warehouse;
    }   
    
    public WarehouseResponse mapToWarehouseResponse(Warehouse warehouse) {
        return WarehouseResponse.builder()
                .wareHouseId(warehouse.getWareHouseId())
                .name(warehouse.getName())
                .totalCapacity(warehouse.getTotalCapacity())
                .build();
		}

		
}
