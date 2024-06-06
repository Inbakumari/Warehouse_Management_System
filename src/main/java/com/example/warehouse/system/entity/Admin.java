package com.example.warehouse.system.entity;

import java.util.List;

import com.example.warehouse.system.enums.AdminType;
import com.example.warehouse.system.enums.Privilege;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter



public class Admin {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int adminId;
	private String name;
	private String email;
	private String password;
	
	//enumeration type
	
	@Enumerated(EnumType.STRING)
	private AdminType adminType;
	
	
	
	

}
