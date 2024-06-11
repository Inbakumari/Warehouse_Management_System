package com.example.warehouse.system.mapper;

import org.springframework.stereotype.Component;

import com.example.warehouse.system.entity.Warehouse;
import com.example.warehouse.system.requestdto.WarehouseRequest;
import com.example.warehouse.system.responsedto.WarehouseResponse;


@Component
public class WareHouseMapper {

	public Warehouse mapToWareHouse(WarehouseRequest wareHouseRequest, Warehouse wareHouse) {
		wareHouse.setName(wareHouseRequest.getName());
		return wareHouse;			
	}	
		
		public WarehouseResponse mapToWareHouseResponse(Warehouse wareHouse) {
			return WarehouseResponse.builder()
					.wareHouseId(wareHouse.getWareHouseId())
					.name(wareHouse.getName())
					.totalCapacity(0)
					.build();
		}

		
}
