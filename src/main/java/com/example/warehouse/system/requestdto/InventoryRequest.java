package com.example.warehouse.system.requestdto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.example.warehouse.system.enums.MaterialTypes;
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
	private List<MaterialTypes> materialTypes;
	private LocalDate restockedAt;
	private int sellerId;

}
