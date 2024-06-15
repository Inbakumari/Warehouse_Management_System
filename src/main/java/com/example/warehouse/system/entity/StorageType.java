package com.example.warehouse.system.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StorageType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int storageTypeId;
	
	private double lengthInMeters;
	private double breadthInMeters;
	private double heightInMeters;
	private double capacityInKg;
	private double unitsAvailable;
	
	
	

}
