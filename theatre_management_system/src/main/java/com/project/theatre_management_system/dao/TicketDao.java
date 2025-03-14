package com.project.theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.theatre_management_system.dto.Payment;
import com.project.theatre_management_system.dto.Ticket;
import com.project.theatre_management_system.repo.TicketRepo;

@Repository
public class TicketDao {

	@Autowired
	TicketRepo ticketRepo;

	@Autowired
	PaymentDao paymentDao;

	public Ticket saveTicket(Ticket ticket) {
		return ticketRepo.save(ticket);
	}

	public Ticket addExistingPaymentToExistingTicket(int paymentId, int ticketId) {
		Payment payment = paymentDao.fetchPaymentById(paymentId);
		Ticket ticket = fetchTicketById(ticketId);
		ticket.setPayment(payment);
		return saveTicket(ticket);
	}

	public Ticket fetchTicketById(int ticketId) {
		Optional<Ticket> dbTicket = ticketRepo.findById(ticketId);
		if(dbTicket.isPresent()) return dbTicket.get();
		return null;
	}

	public List<Ticket> fetchAllTicket() {
		return ticketRepo.findAll();
	}

	public Ticket deleteTicketById(int ticketId) {
		Ticket ticket = fetchTicketById(ticketId);
		ticketRepo.delete(ticket);
		return ticket;
	}

	public Ticket updateTicketById(int oldTicketId, Ticket newTicket) {
		newTicket.setTicketId(oldTicketId);
		return saveTicket(newTicket);
	}
}
