package com.example.warehouse.system.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.warehouse.system.entity.Warehouse;
import com.example.warehouse.system.responsedto.WarehouseResponse;


public interface WareHouseRepository extends JpaRepository<Warehouse, Integer>
{

	

	

}