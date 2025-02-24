package com.project.theatre_management_system.exception;

public class AddressIdNotFound extends RuntimeException{
	private String message = "Address id not found";

	public String getMessage() {
		return message;
	}
}
