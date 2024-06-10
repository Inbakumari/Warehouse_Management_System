package com.example.warehouse.system.responsedto;


import java.util.List;

import com.example.warehouse.system.enums.AdminType;
import com.example.warehouse.system.enums.Privilege;

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
public class AdminResponse {
	
	private int adminId;
	private String name;
	private String email;
	private AdminType adminType;
	
	

}
