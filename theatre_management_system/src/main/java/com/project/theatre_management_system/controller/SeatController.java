package com.project.theatre_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.theatre_management_system.dto.Seat;
import com.project.theatre_management_system.service.SeatService;

@RestController
public class SeatController {

	@Autowired
	SeatService SeatService;
	
	@PostMapping("/saveSeat")
	public Seat saveSeat(@RequestBody Seat Seat) {
		return SeatService.saveSeat(Seat);
	}
	
	@GetMapping("/fetchSeatById")
	public Seat fetchSeatById(@RequestParam int SeatId) {
		return SeatService.fetchSeatById(SeatId);
	}
	
	@GetMapping("/fetchAllSeat")
	public List<Seat> fetchAllSeat() {
		return SeatService.fetchAllSeat();
	}
	
	@DeleteMapping("/deleteSeatById")
	public Seat deleteSeatById(@RequestParam int SeatId) {
		return SeatService.deleteSeatById(SeatId);
	}
	
	@PutMapping("/updateSeatById")
	public Seat updateSeatById(@RequestParam int oldSeatId, @RequestBody Seat newSeat) {
		return SeatService.updateSeatById(oldSeatId, newSeat);
	}
}
