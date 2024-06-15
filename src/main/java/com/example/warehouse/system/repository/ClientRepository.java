package com.example.warehouse.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.warehouse.system.entity.Client;



public interface ClientRepository extends JpaRepository<Client, Integer> {

}
