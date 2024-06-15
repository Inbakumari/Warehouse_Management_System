package com.example.warehouse.system.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.warehouse.system.enums.AdminType;
import com.example.warehouse.system.requestdto.AdminRequest;
import com.example.warehouse.system.responsedto.AdminResponse;
import com.example.warehouse.system.utility.ResponseStructure;

import jakarta.validation.Valid;

public interface AdminService {


	ResponseEntity<ResponseStructure<AdminResponse>> createSuperAdmin(AdminRequest adminRequest);

	ResponseEntity<ResponseStructure<AdminResponse>> createAdmin(AdminRequest adminRequest, int warehouseId);

	ResponseEntity<ResponseStructure<AdminResponse>> updateAdmin(AdminRequest adminRequest);

	ResponseEntity<ResponseStructure<AdminResponse>> updateAdminBySuperAdmin(@Valid AdminRequest adminRequest,
			int adminId);

	ResponseEntity<ResponseStructure<AdminResponse>> findAdmin(int adminId);

	ResponseEntity<ResponseStructure<List<AdminResponse>>> findAdmins(AdminType adminType);







}
