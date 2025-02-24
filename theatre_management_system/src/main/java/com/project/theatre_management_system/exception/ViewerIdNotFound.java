package com.project.theatre_management_system.exception;

public class ViewerIdNotFound extends RuntimeException{
private String message = "Viewer id not found";
	
	public String getMessage() {
		return message;
	}
}
