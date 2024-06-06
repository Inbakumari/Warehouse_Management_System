package com.example.warehouse.system.utility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.warehouse.system.exception.AdminNotFoundByIdException;
import com.example.warehouse.system.exception.IllegalOperationException;

@RestControllerAdvice
public class ApplicationHandler {
	
	
	private ResponseEntity<ErrorStructure> errorResponse(HttpStatus statusCode, String message, String rootCause)
	{
		return ResponseEntity
				.status(statusCode)
				.body(new ErrorStructure()
						.setStatusCode(statusCode.value())
						.setMessage(message)
						.setRootCause(rootCause));
				        
	}
	
	
	
	@ExceptionHandler
	
	public ResponseEntity<ResponseStructure<Map<String, String>>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex)
	{
		List<ObjectError> errors=ex.getAllErrors();
		
		
		Map<String, String> allErrors=new HashMap<String, String>();
		errors.forEach(error -> {
			
			FieldError fieldError=(FieldError) error;
			String field=fieldError.getField();
			String message=fieldError.getDefaultMessage();
			allErrors.put(field, message);
		});
		return ResponseEntity
		.status(HttpStatus.BAD_REQUEST)
		.body(new ResponseStructure<Map<String,String>>()
				.setStatusCode(HttpStatus.BAD_REQUEST.value())
				.setMessage(ex.getMessage())
				.setData(allErrors));
	
	
	
	}
	
@ExceptionHandler
	
	public ResponseEntity<ErrorStructure> handleUserNotFoundById(IllegalOperationException ex)
	{
		return errorResponse(HttpStatus.NOT_FOUND,ex.getMessage(),"Illegal Operation Exception");
	}
	@ExceptionHandler
	
	public ResponseEntity<ErrorStructure> handleUserNotFoundById(AdminNotFoundByIdException ex)
	{
		return errorResponse(HttpStatus.NOT_FOUND,ex.getMessage(),"Admin is not found by the given id");
	}
	
	
	
	

}
	
	
	

