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
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity  
@Setter 
@Getter	
@NoArgsConstructor 
@AllArgsConstructor 
@Builder
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //sql cretes autogeneratn strategy,no need of 'sequence table'
	private int adminId;
	private String name;
	private String email;
	private String password ;
	
	@Enumerated(EnumType.STRING)
    AdminType adminType;

}