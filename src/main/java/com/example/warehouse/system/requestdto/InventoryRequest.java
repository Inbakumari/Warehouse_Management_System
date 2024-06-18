package com.example.warehouse.system.requestdto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.example.warehouse.system.enums.MaterialType;
import com.example.warehouse.system.responsedto.InventoryResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class InventoryRequest {
	
	
	private String productTitle;
	private double lengthInMeters;
	private double breadthInMeters;
	private double heightInMeters;
	private double weightInKG;
	private double quantity;
	private MaterialType materialType;
	private LocalDate restockedAt;
	private int sellerId;

}
