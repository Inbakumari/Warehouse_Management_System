package com.example.warehouse.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.warehouse.system.entity.Storage;

public interface StorageRespository extends JpaRepository<Storage, Integer> {

}
