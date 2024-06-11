package com.example.warehouse.system.mapper;

import org.springframework.stereotype.Component;

import com.example.warehouse.system.entity.WareHouse;
import com.example.warehouse.system.responsedto.WareHouseResponse;


@Component
public class WareHouseMapper {

	public WareHouse mapToWareHouse(WareHouse wareHouseRequest, WareHouse wareHouse) {
		wareHouse.setName(wareHouseRequest.getName());
		return wareHouse;			
	}	
		
		public WareHouseResponse mapToWareHouseResponse(WareHouse wareHouse) {
			return WareHouseResponse.builder()
					.wareHouseId(wareHouse.getWareHouseId())
					.name(wareHouse.getName())
					.totalCapacity(0)
					.build();
		}

		
}
