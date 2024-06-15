package com.example.warehouse.system.responsedto;

import java.util.List;

import com.example.warehouse.system.enums.MaterialType;

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
public class StorageResponse {
	
	private int storageId;
	private String blockName;
	private String section;
	private double capacityInArea;
	private double capacityInKg;
	private List<MaterialType> materialTypes;
	private double maxAdditonalWeight;
	private double availableArea;

}
