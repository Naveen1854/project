package com.project.theatre_management_system.exception;

public class OwnerIdNotFound extends RuntimeException{

	private String message = "owner id not found";
	
	public String getMessage() {
		return message;
	}
}
