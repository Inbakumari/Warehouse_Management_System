package com.example.warehouse.system.responsedto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.example.warehouse.system.entity.Batch;
import com.example.warehouse.system.enums.MaterialTypes;

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
public class InventoryResponse {
	
	
	private int productId;
	private String productTitle;
	private double weightInKg;
	private List<MaterialTypes> materialTypes;
	private LocalDate restockedAt;
    private int sellerId;
    private List<BatchResponse> batches;

}
