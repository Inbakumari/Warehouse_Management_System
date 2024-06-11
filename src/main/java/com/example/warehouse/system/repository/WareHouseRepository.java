package com.example.warehouse.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.warehouse.system.entity.Admin;
import com.example.warehouse.system.entity.WareHouse;

public interface WareHouseRepository extends JpaRepository<WareHouse, Integer>
{

}