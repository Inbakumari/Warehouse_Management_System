package com.example.warehouse.system.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.warehouse.system.entity.Address;
import com.example.warehouse.system.entity.Warehouse;

public interface AddressRepository extends JpaRepository<Address, Integer> {

	List<Address> findAllByCity(String city);

}
