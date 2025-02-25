package com.project.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.theatre_management_system.dao.TicketDao;
import com.project.theatre_management_system.dto.Ticket;
import com.project.theatre_management_system.exception.TicketIdNotFound;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

@Service
public class TicketService {

	@Autowired
	TicketDao ticketDao;
	
	@Autowired
	ResponseStructure<Ticket> responseStructure;
	
	@Autowired
	ResponseStructureList<Ticket> responseStructureList;
	
	public ResponseEntity<ResponseStructure<Ticket>> saveTicket(Ticket ticket) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Succesfully Saved the Ticket into db");
		responseStructure.setData(ticketDao.saveTicket(ticket));
		return new ResponseEntity<ResponseStructure<Ticket>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Ticket>> addExistingPaymentToExistingTicket(int paymentId, int ticketId) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Succesfully added Existing Payment To Existing Ticket in to db");
		responseStructure.setData(ticketDao.addExistingPaymentToExistingTicket(paymentId, ticketId));
		return new ResponseEntity<ResponseStructure<Ticket>>(responseStructure,HttpStatus.FOUND);
	}
	
	public ResponseEntity<ResponseStructure<Ticket>> fetchTicketById(int ticketId) {
		Ticket ticket = ticketDao.fetchTicketById(ticketId);
		if(ticket != null) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Succesfully fetched Ticket By Id from db");
		responseStructure.setData(ticketDao.fetchTicketById(ticketId));
		return new ResponseEntity<ResponseStructure<Ticket>>(responseStructure,HttpStatus.FOUND);
		}else {
			throw new TicketIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructureList<Ticket>> fetchAllTicket() {
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Succesfully fetch All Tickets from db");
		responseStructureList.setData(ticketDao.fetchAllTicket());
		return new ResponseEntity<ResponseStructureList<Ticket>>(responseStructureList,HttpStatus.FOUND);
	}
	
	public ResponseEntity<ResponseStructure<Ticket>> deleteTicketById(int ticketId) {
		Ticket ticket = ticketDao.fetchTicketById(ticketId);
		if(ticket != null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Succesfully deleted Ticket By Id from db");
		responseStructure.setData(ticketDao.deleteTicketById(ticketId));
		return new ResponseEntity<ResponseStructure<Ticket>>(responseStructure,HttpStatus.OK);
		}else {
			throw new TicketIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Ticket>> updateTicketById(int oldTicketId, Ticket newTicket) {
		Ticket ticket = ticketDao.fetchTicketById(oldTicketId);
		if(ticket != null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Succesfully updated Ticket By Id from db");
		responseStructure.setData(ticketDao.updateTicketById(oldTicketId, newTicket));
		return new ResponseEntity<ResponseStructure<Ticket>>(responseStructure,HttpStatus.OK);
		}else {
			throw new TicketIdNotFound();
		}
	}
}
