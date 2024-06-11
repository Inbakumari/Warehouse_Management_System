package com.example.warehouse.system.requestdto;

import java.util.List;

import com.example.warehouse.system.enums.AdminType;
import com.example.warehouse.system.enums.Privilege;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminRequest {

	@NotNull(message="username cannot be null")
	@NotBlank(message="username cannot be blank")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Name should only contain alphabetic characters")

	private String name;
	
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@gmail\\.com$", message = "Email should end with @gmail.com")	@NotNull(message="email cannot be null")
	@NotBlank(message="email cannot be null")
	
	private String email;
	
	@Pattern(regexp = "^(?=.[0-9])(?=.[a-z])(?=.[A-Z])(?=.[@#$%^&+=])(?=\\S+$).{8,}$", 
			message = "Password must contain at least one letter, one number, one special character, and be at least 8 characters long")
	private String password ;
<<<<<<< HEAD
	
	
	
	
=======
	
	private AdminType adminType;
	
	
>>>>>>> 62a9606d3f3218591ed5962733402d8c0f30736e
}