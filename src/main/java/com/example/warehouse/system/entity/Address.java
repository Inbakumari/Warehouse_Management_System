package com.example.warehouse.system.entity;

import com.example.warehouse.system.enums.AdminType;

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
@NoArgsConstructor 
@AllArgsConstructor 
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;
	private String addressLine;
	private String city;
	private String state;
	private String country;
	private int pincode;
	private String longitude;
	private String latitude;
	
	
	@OneToOne
	private Warehouse warehouse;
	
	
}
