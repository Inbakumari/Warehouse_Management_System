package com.example.warehouse.system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
<<<<<<< HEAD
=======
import lombok.AllArgsConstructor;
import lombok.Builder;
>>>>>>> 62a9606d3f3218591ed5962733402d8c0f30736e
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
<<<<<<< HEAD
public class Warehouse {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int warehouseId;
	private String name;
	
	@OneToOne
	
	private Admin admin;
=======
@AllArgsConstructor
@NoArgsConstructor
//@Entity  //it indicates table
//@Setter //will implicitly crete setter() will be visible in outline
//@Getter	//will implicitly crete getter() will be visible in outline
//@NoArgsConstructor //will implicitly crete noargsconstrutor() will be visible in outline
//@AllArgsConstructor //will implicitly crete allargsconstrutor() will be visible in outline
@Builder
public class WareHouse {
>>>>>>> 62a9606d3f3218591ed5962733402d8c0f30736e

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //sql cretes autogeneratn strategy,no need of 'sequence table'
	
	private int wareHouseId;
	
	private String name; 
	
	@OneToOne 
	private Admin admin;
}
