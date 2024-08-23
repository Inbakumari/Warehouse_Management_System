package com.example.warehouse.system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.warehouse.system.entity.Admin;
import com.example.warehouse.system.entity.Client;



public interface ClientRepository extends JpaRepository<Client, Integer> {
	
	public Optional<Client> findByEmail(String username);
	
}
