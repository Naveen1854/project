package com.project.theatre_management_system.exception;

public class TheatreIdNotFound extends RuntimeException{
private String message = "Theatre id not found";
	
	public String getMessage() {
		return message;
	}
}
