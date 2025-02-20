package com.project.theatre_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.theatre_management_system.dto.Ticket;
import com.project.theatre_management_system.service.TicketService;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

@RestController
public class TicketController {

	@Autowired
	TicketService ticketService;

	@PostMapping("/saveTicket")
	public ResponseStructure<Ticket> saveTicket(@RequestBody Ticket ticket) {
		return ticketService.saveTicket(ticket);
	}

	@GetMapping("/fetchTicketById")
	public ResponseStructure<Ticket> fetchTicketById(@RequestParam int TicketId) {
		return ticketService.fetchTicketById(TicketId);
	}

	@GetMapping("/fetchAllTicket")
	public ResponseStructureList<Ticket> fetchAllTicket() {
		return ticketService.fetchAllTicket();
	}

	@DeleteMapping("/deleteTicketById")
	public ResponseStructure<Ticket> deleteTicketById(@RequestParam int TicketId) {
		return ticketService.deleteTicketById(TicketId);
	}

	@PutMapping("/updateTicketById")
	public ResponseStructure<Ticket> updateTicketById(@RequestParam int oldTicketId, @RequestBody Ticket newTicket) {
		return ticketService.updateTicketById(oldTicketId, newTicket);
	}

	@PutMapping("/addExistingPaymentToExistingTicket")
	public ResponseStructure<Ticket> addExistingPaymentToExistingTicket(@RequestParam int paymentId,
			@RequestParam int ticketId) {
		return ticketService.addExistingPaymentToExistingTicket(paymentId, ticketId);
	}
}
