package com.example.warehouse.system.entity;

import com.example.warehouse.system.responsedto.StorageResponse;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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

public class Batch {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int batchId;
	private double quantity;
	
	
	@ManyToOne
	private Inventory inventory;
	
	@ManyToOne
	private Storage storage;

}
