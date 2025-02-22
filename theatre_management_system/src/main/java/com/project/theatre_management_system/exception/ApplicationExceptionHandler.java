package com.project.theatre_management_system.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.theatre_management_system.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	
	@Autowired
	ResponseStructure<String> responseStructure;
	
	@ExceptionHandler(OwnerIdNotFound.class)
	public ResponseStructure<String> OwnerIdNotFound(OwnerIdNotFound ownerIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Owner Id is not Found in DB");
		responseStructure.setData(ownerIdNotFound.getMessage());
		return responseStructure;
	}
}
