package com.example.warehouse.system.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor 
@AllArgsConstructor

public class Client {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int clientId;
	private String businessName;
	private String email;
	private String contactNumber;
	private String apiKey;
	

}
