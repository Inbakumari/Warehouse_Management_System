package com.example.warehouse.system.utility;



public class ResponseStructure<T> {
	
	private int statusCode;
	private String message;
	private T data;
	public int getStatusCode() {
		return statusCode;
	}
	public T getData() {
		return data;
	}
	public String getMessage() {
		return message;
	}
	public ResponseStructure<T> setMessage(String message) {
		this.message = message;
		return this;
	}
	public ResponseStructure<T> setStatusCode(int statusCode) {
		this.statusCode = statusCode;
		return this;
	}
	
	public ResponseStructure<T> setData(T data) {
		this.data = data;
		return this;
	}
	
	
	
	
	
	

}
