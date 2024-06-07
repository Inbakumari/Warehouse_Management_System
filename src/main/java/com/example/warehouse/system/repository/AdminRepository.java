package com.example.warehouse.system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import com.example.warehouse.system.entity.Admin;
import com.example.warehouse.system.enums.AdminType;
import com.example.warehouse.system.responsedto.AdminResponse;
import com.example.warehouse.system.utility.ResponseStructure;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

	

	public boolean existsByAdminType(AdminType adminType);

	public Optional<Admin> findByEmail(String username);
	
}
