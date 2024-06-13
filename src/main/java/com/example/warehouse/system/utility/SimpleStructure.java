package com.example.warehouse.system.utility;



public class SimpleStructure<T> {
	
	private int status;
	private String message;
	public int getStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}
	public SimpleStructure<T> setStatus(int status) {
		this.status = status;
		return this;
	}
	public SimpleStructure<T> setMessage(String message) {
		this.message = message;
		return this;
	}
	
	

}
