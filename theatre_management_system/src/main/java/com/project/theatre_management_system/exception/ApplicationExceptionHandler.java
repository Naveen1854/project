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

	@ExceptionHandler(AddressIdNotFound.class)
	public ResponseStructure<String> AddressIdNotFound(AddressIdNotFound addressIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Address Id is not Found in DB");
		responseStructure.setData(addressIdNotFound.getMessage());
		return responseStructure;
	}

	@ExceptionHandler(BranchIdNotFound.class)
	public ResponseStructure<String> BranchIdNotFound(BranchIdNotFound branchIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Branch Id Not found in database");
		responseStructure.setData(branchIdNotFound.getMessage());
		return responseStructure;

	}

	@ExceptionHandler(FoodIdNotFound.class)
	public ResponseStructure<String> FoodIdNotFound(FoodIdNotFound foodIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Food Id Not Found In DataBase");
		responseStructure.setData(foodIdNotFound.getMessage());
		return responseStructure;
	}

	@ExceptionHandler(ManagerIdNotFound.class)
	public ResponseStructure<String> ManagerIdNotFound(ManagerIdNotFound managerIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Manager Id Not Found in DataBase");
		responseStructure.setData(managerIdNotFound.getMessage());
		return responseStructure;
	}

	@ExceptionHandler(MovieIdNotFound.class)
	public ResponseStructure<String> MovieIdNotFound(MovieIdNotFound movieIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Movie Id Not Found In DataBase");
		responseStructure.setData(movieIdNotFound.getMessage());
		return responseStructure;
	}

	@ExceptionHandler(PaymentIdNotFound.class)
	public ResponseStructure<String> PaymentIdNotFound(PaymentIdNotFound paymentIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Payment Id Not found In DataBase");
		responseStructure.setData(paymentIdNotFound.getMessage());
		return responseStructure;
	}

	@ExceptionHandler(ReviewIdNotFound.class)
	public ResponseStructure<String> ReviewIdNotFound(ReviewIdNotFound reviewIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Review Id Not Found In DataBase");
		responseStructure.setData(reviewIdNotFound.getMessage());
		return responseStructure;
	}

	@ExceptionHandler(ScreenIdNotFound.class)
	public ResponseStructure<String> ScreenIdNotFound(ScreenIdNotFound screenIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Screen Id Not found in database");
		responseStructure.setData(screenIdNotFound.getMessage());
		return responseStructure;
	}

	@ExceptionHandler(SeatIdNotFound.class)
	public ResponseStructure<String> SeatIdNotFound(SeatIdNotFound seatIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Seat Id Not found in dataBase");
		responseStructure.setData(seatIdNotFound.getMessage());
		return responseStructure;
	}

	@ExceptionHandler(StaffIdNotFound.class)
	public ResponseStructure<String> StaffIdNotFound(StaffIdNotFound staffIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Staff Id Not Found in database");
		responseStructure.setData(staffIdNotFound.getMessage());
		return responseStructure;
	}

	@ExceptionHandler(TheatreIdNotFound.class)
	public ResponseStructure<String> TheatreIdNotFound(TheatreIdNotFound theatreIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Theatre Id Not Found In dataBase");
		responseStructure.setData(theatreIdNotFound.getMessage());
		return responseStructure;
	}

	@ExceptionHandler(TicketIdNotFound.class)
	public ResponseStructure<String> TicketIdNtFound(TicketIdNotFound ticketIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Ticket Id Not Found in dataBase");
		responseStructure.setData(ticketIdNotFound.getMessage());
		return responseStructure;
	}

	@ExceptionHandler(ViewerIdNotFound.class)
	public ResponseStructure<String> ViewerIdNotFound(ViewerIdNotFound viewerIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Viewer id not found in dataBase");
		responseStructure.setData(viewerIdNotFound.getMessage());
		return responseStructure;
	}

}
