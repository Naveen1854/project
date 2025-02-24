package com.project.theatre_management_system.exception;

public class ReviewIdNotFound extends RuntimeException{
private String message = "Review id not found";
	
	public String getMessage() {
		return message;
	}
}
