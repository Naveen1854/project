package com.project.theatre_management_system.exception;

public class ManagerIdNotFound extends RuntimeException{

private String message = "Manager id not found";
	
	public String getMessage() {
		return message;
	}
}
