package com.example.warehouse.system.requestdto;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class WarehouseRequest {
	
	
	@Pattern(regexp="^[a-zA-Z]+$", message="The username should contain only alphabets."
			 +" should not contains any numeric character, special character")
	private String name;

}
