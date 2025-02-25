package com.project.theatre_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.theatre_management_system.dto.Seat;
import com.project.theatre_management_system.service.SeatService;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class SeatController {

	@Autowired
	SeatService SeatService;

	@Operation(summary = "Save Seat", description = "API is used to save the Seat")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created") })
	@PostMapping("/saveSeat")
	public ResponseEntity<ResponseStructure<Seat>> saveSeat(@RequestBody Seat Seat) {
		return SeatService.saveSeat(Seat);
	}

	@Operation(summary = "fetch Seat", description = "API is used to fetch the Seat")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully saved"),
			@ApiResponse(responseCode = "404", description = "Seat not found for the given id") })
	@GetMapping("/fetchSeatById")
	public ResponseEntity<ResponseStructure<Seat>> fetchSeatById(@RequestParam int SeatId) {
		return SeatService.fetchSeatById(SeatId);
	}

	@Operation(summary = "fetch all Seat", description = "API is used to fetch all the Seats")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully fetched") })
	@GetMapping("/fetchAllSeat")
	public ResponseEntity<ResponseStructureList<Seat>> fetchAllSeat() {
		return SeatService.fetchAllSeat();
	}

	@Operation(summary = "delete Seat", description = "API is used to delete the Seat")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully deleted"),
			@ApiResponse(responseCode = "404", description = "Seat not found for the given id") })
	@DeleteMapping("/deleteSeatById")
	public ResponseEntity<ResponseStructure<Seat>> deleteSeatById(@RequestParam int SeatId) {
		return SeatService.deleteSeatById(SeatId);
	}

	@Operation(summary = "update Seat", description = "API is used to update the Seat")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully updated"),
			@ApiResponse(responseCode = "404", description = "Seat not found for the given id") })
	@PutMapping("/updateSeatById")
	public ResponseEntity<ResponseStructure<Seat>> updateSeatById(@RequestParam int oldSeatId,
			@RequestBody Seat newSeat) {
		return SeatService.updateSeatById(oldSeatId, newSeat);
	}
}
