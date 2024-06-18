package com.example.warehouse.system.entity;

import java.util.List;

import com.example.warehouse.system.enums.MaterialType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
public class Storage {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private int storageId;
	private String blockName;
	private String section;
	List< MaterialType> materialTypes;
	private double maxAdditionalWeight;
	private double availabeArea;
	private int sellerId;


	@ManyToOne	
	private Warehouse warehouse;
	
	@ManyToOne
	
	private StorageType storageType;


}
