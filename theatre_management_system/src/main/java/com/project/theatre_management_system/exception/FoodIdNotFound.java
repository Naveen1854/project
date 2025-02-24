package com.project.theatre_management_system.exception;

public class FoodIdNotFound extends RuntimeException{

private String message = "Food id not found";
	
	public String getMessage() {
		return message;
	}
}
