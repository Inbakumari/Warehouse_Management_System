package com.example.warehouse.system.service;

import org.springframework.http.ResponseEntity;

import com.example.warehouse.system.enums.AdminType;
import com.example.warehouse.system.requestdto.AdminRequest;
import com.example.warehouse.system.responsedto.AdminResponse;
import com.example.warehouse.system.utility.ResponseStructure;

public interface AdminService {

	

	

	ResponseEntity<ResponseStructure<AdminResponse>> createSuperAdmin(AdminRequest adminRequest);
	ResponseEntity<ResponseStructure<AdminResponse>> createAdmin(AdminRequest adminRequest);
	

	
	

}
