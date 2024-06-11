package com.example.warehouse.system.mapper;

import com.example.warehouse.system.entity.Admin;
import com.example.warehouse.system.requestdto.AdminRequest;
import com.example.warehouse.system.responsedto.AdminResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminMapper {

	@Autowired
	PasswordEncoder passwordEncoder;

	public Admin mapToAdmin(AdminRequest adminRequest, Admin admin) {
		admin.setName(adminRequest.getName());
		admin.setEmail(adminRequest.getEmail());
		admin.setPassword(passwordEncoder.encode(adminRequest.getPassword()));
		return admin;
	}

	public AdminResponse mapToAdminResponse(Admin admin) {
		return AdminResponse.builder()
				.adminId(admin.getAdminId())
				.name(admin.getName())
				.email(admin.getEmail())
				.adminType(admin.getAdminType())
				.build();
	}
}