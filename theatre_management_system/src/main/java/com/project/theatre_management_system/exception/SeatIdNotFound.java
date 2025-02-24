package com.project.theatre_management_system.exception;

public class SeatIdNotFound extends RuntimeException{
private String message = "Seat id not found";
	
	public String getMessage() {
		return message;
	}
}
