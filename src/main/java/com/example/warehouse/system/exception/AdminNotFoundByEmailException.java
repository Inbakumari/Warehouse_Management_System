package com.example.warehouse.system.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AdminNotFoundByEmailException extends RuntimeException {
	
	private String message;

}
