package com.example.warehouse.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.warehouse.system.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

}
