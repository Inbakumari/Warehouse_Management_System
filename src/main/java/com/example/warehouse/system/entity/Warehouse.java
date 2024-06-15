package com.example.warehouse.system.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
public class Warehouse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	
	private int wareHouseId;
	private String name; 
	private double totalCapacityInKg;
	
	
	
	@OneToOne 
	private Admin admin;
	
	
	@OneToMany(mappedBy="warehouse")
	private List<Storage> storages;
	
	
}
