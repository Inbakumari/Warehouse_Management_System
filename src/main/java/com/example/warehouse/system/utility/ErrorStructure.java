package com.example.warehouse.system.utility;

public class ErrorStructure{
	
	private int statusCode;
	private String message;
	private String rootCause;
	public int getStatusCode() {
		return statusCode;
	}
	public String getMessage() {
		return message;
	}
	public String getRootCause() {
		return rootCause;
	}
	public ErrorStructure setStatusCode(int statusCode) {
		this.statusCode = statusCode;
		return this;
	}
	public ErrorStructure setMessage(String message) {
		this.message = message;
		return this;
	}
	public ErrorStructure setRootCause(String rootCause) {
		this.rootCause = rootCause;
		return this;
	}
	
	
	
	

}
