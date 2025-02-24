package com.project.theatre_management_system.exception;

public class BranchIdNotFound extends RuntimeException{

private String message = "Branch id not found";
	
	public String getMessage() {
		return message;
	}
}
