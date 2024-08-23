package com.example.warehouse.system.responsedto;

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
public class BatchResponse {
	
	
	private int batchId;
	private int quantity;
	private StorageResponse storage;

}
