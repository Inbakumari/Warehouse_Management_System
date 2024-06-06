package com.example.warehouse.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.warehouse.system.entity.Admin;

public interface WareHouseRepository extends JpaRepository<Admin, Integer>
{

}
