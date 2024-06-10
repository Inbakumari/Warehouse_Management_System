package com.example.warehouse.system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Warehouse {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	
	
    private int warehouseId;
	private String name;
	
	@OneToOne
	private Admin admin;

}
