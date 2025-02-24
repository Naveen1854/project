package com.project.theatre_management_system.exception;

public class MovieIdNotFound extends RuntimeException{
private String message = "Movie id not found";
	
	public String getMessage() {
		return message;
	}
}
