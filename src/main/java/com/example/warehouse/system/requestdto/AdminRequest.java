package com.example.warehouse.system.requestdto;

import java.util.List;

import com.example.warehouse.system.enums.AdminType;
import com.example.warehouse.system.enums.Privilege;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminRequest {
	
	
	
	@Pattern(regexp="^[a-zA-Z]+$", message="The username should contain only alphabets."
			 +" should not contains any numeric character, special character")
	private String name;
	
	@Email(regexp= "^[a-zA-Z0-9+_.%-]+@gmail\\.com$",message="Invalid email")
	private String email;
	
	@Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}", message = "Password must contain at least one letter, one number, one special character")
	private String password;
	
	
	

}
