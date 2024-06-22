package com.example.warehouse.system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.warehouse.system.entity.Batch;
import com.example.warehouse.system.entity.Inventory;
import com.example.warehouse.system.entity.Storage;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

	
}
