package com.example.warehouse.system.responsedto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressResponse {
	
	private int addressId;
	private String addressLine;
	private String city;
	private String state;
	private String country;
	private long pincode;
	private String longitude;
	private String latitude;

}
