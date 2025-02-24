package com.project.theatre_management_system.exception;

public class ScreenIdNotFound extends RuntimeException{
private String message = "Screen id not found";
	
	public String getMessage() {
		return message;
	}
}
