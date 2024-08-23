package com.example.warehouse.system.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.warehouse.system.entity.Address;
import com.example.warehouse.system.entity.Warehouse;
import com.example.warehouse.system.requestdto.WarehouseRequest;
import com.example.warehouse.system.responsedto.WarehouseResponse;


@Component
public class WareHouseMapper {
	
	@Autowired
	
	private AddressMapper addressMapper;

	public Warehouse mapToWarehouse(WarehouseRequest warehouseRequest, Warehouse warehouse) {
        warehouse.setName(warehouseRequest.getName());
        return warehouse;
    }   
    
    public WarehouseResponse mapToWarehouseResponse(Warehouse warehouse) {
        return WarehouseResponse.builder()
                .wareHouseId(warehouse.getWareHouseId())
                .name(warehouse.getName())
                .totalCapacityInKg(warehouse.getTotalCapacityInKg())
                .build();
		}
    
    
    public WarehouseResponse mapToWarehouseResponse(Warehouse warehouse, Address address) 
    {
    	
    	WarehouseResponse warehouseResponse = mapToWarehouseResponse(warehouse);
    	warehouseResponse.setAddressResponse(addressMapper.mapToAddressResponse(address));
    	return warehouseResponse;
    }
    
    
    }

		

