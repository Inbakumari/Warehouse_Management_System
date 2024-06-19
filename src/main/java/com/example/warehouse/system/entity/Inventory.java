package com.example.warehouse.system.entity;

import java.time.LocalDate;

import java.util.List;

import com.example.warehouse.system.enums.MaterialType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Inventory {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int productId;
	private String productTitle;
	private double lengthInMeters;
	private double breadthInMeters;
	private double heightInMeters;
	private double weightInKG;
	private double quantity;
	private MaterialType materialType;
	private LocalDate restockedAt;
	private int sellerId;
	
	
	@ManyToMany(mappedBy = "inventories")
    private List<Storage> storages;;
    
    @OneToOne
    
    private  Client client;

}
