package com.example.warehouse.system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.warehouse.system.entity.Admin;
import com.example.warehouse.system.enums.AdminType;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

	public boolean existsByAdminType(AdminType adminType);

	public Optional<Admin> findByEmail(String username);
	
}
