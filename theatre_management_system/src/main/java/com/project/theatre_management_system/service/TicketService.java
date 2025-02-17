package com.project.theatre_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.theatre_management_system.dao.TicketDao;
import com.project.theatre_management_system.dto.Ticket;

@Service
public class TicketService {

	@Autowired
	TicketDao ticketDao;
	
	public Ticket saveTicket(Ticket ticket) {
		return ticketDao.saveTicket(ticket);
	}
	
	public Ticket addExistingPaymentToExistingTicket(int paymentId, int ticketId) {
		return ticketDao.addExistingPaymentToExistingTicket(paymentId, ticketId);
	}
	
	public Ticket fetchTicketById(int ticketId) {
		return ticketDao.fetchTicketById(ticketId);
	}
	
	public List<Ticket> fetchAllTicket() {
		return ticketDao.fetchAllTicket();
	}
	
	public Ticket deleteTicketById(int ticketId) {
		return ticketDao.deleteTicketById(ticketId);
	}
	
	public Ticket updateTicketById(int oldTicketId, Ticket newTicket) {
		return ticketDao.updateTicketById(oldTicketId, newTicket);
	}
}
