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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class TicketController {

	@Autowired
	TicketService ticketService;

	@Operation(summary = "Save Ticket", description = "API is used to save the Ticket")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created") })
	@PostMapping("/saveTicket")
	public ResponseStructure<Ticket> saveTicket(@RequestBody Ticket ticket) {
		return ticketService.saveTicket(ticket);
	}

	@Operation(summary = "fetch Ticket", description = "API is used to fetch the Ticket")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully saved"),
			@ApiResponse(responseCode = "404", description = "Ticket not found for the given id") })
	@GetMapping("/fetchTicketById")
	public ResponseStructure<Ticket> fetchTicketById(@RequestParam int TicketId) {
		return ticketService.fetchTicketById(TicketId);
	}

	@Operation(summary = "fetch all Ticket", description = "API is used to fetch all the Ticket")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully fetched") })
	@GetMapping("/fetchAllTicket")
	public ResponseStructureList<Ticket> fetchAllTicket() {
		return ticketService.fetchAllTicket();
	}

	@Operation(summary = "delete Ticket", description = "API is used to delete the Ticket")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully deleted"),
			@ApiResponse(responseCode = "404", description = "Ticket not found for the given id") })
	@DeleteMapping("/deleteTicketById")
	public ResponseStructure<Ticket> deleteTicketById(@RequestParam int TicketId) {
		return ticketService.deleteTicketById(TicketId);
	}

	@Operation(summary = "update Ticket", description = "API is used to update the Ticket")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully updated"),
			@ApiResponse(responseCode = "404", description = "Ticket not found for the given id") })
	@PutMapping("/updateTicketById")
	public ResponseStructure<Ticket> updateTicketById(@RequestParam int oldTicketId, @RequestBody Ticket newTicket) {
		return ticketService.updateTicketById(oldTicketId, newTicket);
	}

	@Operation(summary = "add Existing Payment To Existing Ticket", description = "API is used to addExistingPaymentToExistingTicket")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully added"),
			@ApiResponse(responseCode = "404", description = "Payment/Ticket not found for the given id") })
	@PutMapping("/addExistingPaymentToExistingTicket")
	public ResponseStructure<Ticket> addExistingPaymentToExistingTicket(@RequestParam int paymentId,
			@RequestParam int ticketId) {
		return ticketService.addExistingPaymentToExistingTicket(paymentId, ticketId);
	}
}
