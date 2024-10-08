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
public class ClientResponse {
	
	private int clientId;
	private String businessName;
	private String email;
	private String contactNumber;
	

}
