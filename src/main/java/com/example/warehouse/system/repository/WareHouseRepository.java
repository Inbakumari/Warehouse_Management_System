package com.example.warehouse.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.warehouse.system.entity.Admin;
import com.example.warehouse.system.entity.Warehouse;

public interface WareHouseRepository extends JpaRepository<Warehouse, Integer>
{

}
