package com.project.theatre_management_system.exception;

public class TicketIdNotFound extends RuntimeException{
private String message = "Ticket id not found";
	
	public String getMessage() {
		return message;
	}
}
