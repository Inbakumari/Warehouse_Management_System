package com.example.warehouse.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.warehouse.system.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
