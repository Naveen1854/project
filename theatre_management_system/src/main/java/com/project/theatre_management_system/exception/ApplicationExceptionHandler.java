package com.project.theatre_management_system.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.theatre_management_system.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@Autowired
	ResponseStructure<String> responseStructure;

	@ExceptionHandler(OwnerIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> OwnerIdNotFound(OwnerIdNotFound ownerIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Owner Id is not Found in DB");
		responseStructure.setData(ownerIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AddressIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> AddressIdNotFound(AddressIdNotFound addressIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Address Id is not Found in DB");
		responseStructure.setData(addressIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(BranchIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> BranchIdNotFound(BranchIdNotFound branchIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Branch Id Not found in database");
		responseStructure.setData(branchIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(FoodIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> FoodIdNotFound(FoodIdNotFound foodIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Food Id Not Found In DataBase");
		responseStructure.setData(foodIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ManagerIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> ManagerIdNotFound(ManagerIdNotFound managerIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Manager Id Not Found in DataBase");
		responseStructure.setData(managerIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MovieIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> MovieIdNotFound(MovieIdNotFound movieIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Movie Id Not Found In DataBase");
		responseStructure.setData(movieIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(PaymentIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> PaymentIdNotFound(PaymentIdNotFound paymentIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Payment Id Not found In DataBase");
		responseStructure.setData(paymentIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ReviewIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> ReviewIdNotFound(ReviewIdNotFound reviewIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Review Id Not Found In DataBase");
		responseStructure.setData(reviewIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ScreenIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> ScreenIdNotFound(ScreenIdNotFound screenIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Screen Id Not found in database");
		responseStructure.setData(screenIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(SeatIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> SeatIdNotFound(SeatIdNotFound seatIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Seat Id Not found in dataBase");
		responseStructure.setData(seatIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(StaffIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> StaffIdNotFound(StaffIdNotFound staffIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Staff Id Not Found in database");
		responseStructure.setData(staffIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(TheatreIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> TheatreIdNotFound(TheatreIdNotFound theatreIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Theatre Id Not Found In dataBase");
		responseStructure.setData(theatreIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(TicketIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> TicketIdNtFound(TicketIdNotFound ticketIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Ticket Id Not Found in dataBase");
		responseStructure.setData(ticketIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ViewerIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> ViewerIdNotFound(ViewerIdNotFound viewerIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Viewer id not found in dataBase");
		responseStructure.setData(viewerIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

}
