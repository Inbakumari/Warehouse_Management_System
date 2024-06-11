package com.example.warehouse.system.requestdto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WarehouseRequest {

	@NotNull(message="username cannot be null")
	@NotBlank(message="username cannot be blank")
	private String name; 

	

}
