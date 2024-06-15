package com.example.warehouse.system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import com.example.warehouse.system.entity.Storage;
import com.example.warehouse.system.responsedto.StorageResponse;
import com.example.warehouse.system.utility.ResponseStructure;

public interface StorageRespository extends JpaRepository<Storage, Integer> {

	Optional<Storage> findByCapacityInKgAndLengthInMetersAndBreadthInMetersAndHeightInMeters(double capacityInKg, double lengthInMeters, double breadthInMeters, double HeightInMeters);

}
