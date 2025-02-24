package com.project.theatre_management_system.exception;

public class StaffIdNotFound extends RuntimeException{
private String message = "Staff id not found";
	
	public String getMessage() {
		return message;
	}
}
