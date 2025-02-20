package com.project.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.theatre_management_system.dao.TicketDao;
import com.project.theatre_management_system.dto.Ticket;
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
	
	public ResponseStructure<Ticket> saveTicket(Ticket ticket) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Succesfully Saved the Owner into db");
		responseStructure.setData(ticketDao.saveTicket(ticket));
		return responseStructure;
	}
	
	public ResponseStructure<Ticket> addExistingPaymentToExistingTicket(int paymentId, int ticketId) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Succesfully Saved the Owner into db");
		responseStructure.setData(ticketDao.addExistingPaymentToExistingTicket(paymentId, ticketId));
		return responseStructure;
	}
	
	public ResponseStructure<Ticket> fetchTicketById(int ticketId) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Succesfully Saved the Owner into db");
		responseStructure.setData(ticketDao.fetchTicketById(ticketId));
		return responseStructure;
	}
	
	public ResponseStructureList<Ticket> fetchAllTicket() {
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Succesfully Address fetched by id from db");
		responseStructureList.setData(ticketDao.fetchAllTicket());
		return responseStructureList;
	}
	
	public ResponseStructure<Ticket> deleteTicketById(int ticketId) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Succesfully Address fetched by id from db");
		responseStructure.setData(ticketDao.deleteTicketById(ticketId));
		return responseStructure;
	}
	
	public ResponseStructure<Ticket> updateTicketById(int oldTicketId, Ticket newTicket) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Succesfully Address fetched by id from db");
		responseStructure.setData(ticketDao.updateTicketById(oldTicketId, newTicket));
		return responseStructure;
	}
}
