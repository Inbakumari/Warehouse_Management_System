package com.example.warehouse.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.warehouse.system.entity.StorageType;

public interface StorageTypeRepository extends JpaRepository<StorageType, Integer> {
	
	

}
