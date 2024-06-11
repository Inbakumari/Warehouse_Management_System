package com.example.warehouse.system.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor

public class WarehouseNotFoundByIdException extends RuntimeException {
private String message;
}
