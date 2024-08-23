package com.example.warehouse.system.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor

public class WarehouseNotFoundByIdException extends RuntimeException {
	private String message;
}
