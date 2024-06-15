package com.example.warehouse.system.responsedto;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.warehouse.system.entity.Address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WarehouseResponse {

	private int wareHouseId;
	private String name; 
	private double totalCapacityInKg;
	private AddressResponse addressResponse;
	
	
}