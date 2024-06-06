package com.example.warehouse.system.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AdminNotFoundByIdException extends RuntimeException {
	
	private String message;

}
