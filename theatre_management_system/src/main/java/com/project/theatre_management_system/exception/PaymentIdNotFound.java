package com.project.theatre_management_system.exception;

public class PaymentIdNotFound extends RuntimeException{
private String message = "Payment id not found";
	
	public String getMessage() {
		return message;
	}
}
