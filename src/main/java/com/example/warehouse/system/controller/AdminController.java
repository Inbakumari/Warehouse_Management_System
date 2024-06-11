package com.example.warehouse.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.warehouse.system.requestdto.AdminRequest;
import com.example.warehouse.system.responsedto.AdminResponse;
import com.example.warehouse.system.service.AdminService;
import com.example.warehouse.system.utility.ResponseStructure;

import jakarta.validation.Valid;


@RestController  
@RequestMapping("/api/v1")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping("/register")  
	public ResponseEntity<ResponseStructure<AdminResponse>>createSuperAdmin(@RequestBody AdminRequest adminRequest){
		return adminService.createSuperAdmin(adminRequest);
	}

	@PostMapping("/warehouses/{wareHouseId}/admins") 
	public ResponseEntity<ResponseStructure<AdminResponse>>	createAdmin(@RequestBody @Valid AdminRequest adminRequest,@PathVariable int wareHouseId){
		return  adminService.createAdmin(adminRequest,wareHouseId);
	}

	@PutMapping("/admins")

	public ResponseEntity<ResponseStructure<AdminResponse>>	updateAdmin(@RequestBody @Valid AdminRequest adminRequest){
		return  adminService.updateAdmin(adminRequest);
	}


	@PutMapping("/admins/{adminId}")
	public ResponseEntity<ResponseStructure<AdminResponse>> updateAdminBySuperAdmin(@RequestBody @Valid AdminRequest adminRequest,@PathVariable int adminId ) {
	    return adminService.updateAdminBySuperAdmin(adminRequest,adminId);
	}
	
	

}
