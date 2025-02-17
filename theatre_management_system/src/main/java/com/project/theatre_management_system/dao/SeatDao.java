package com.project.theatre_management_system.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.theatre_management_system.dto.Seat;
import com.project.theatre_management_system.repo.SeatRepo;

@Repository
public class SeatDao {
	@Autowired
	SeatRepo seatRepo;

	public Seat saveSeat(Seat Seat) {
		return seatRepo.save(Seat);
	}

	public Seat fetchSeatById(int SeatId) {
		return seatRepo.findById(SeatId).get();
	}

	public List<Seat> fetchAllSeat() {
		return seatRepo.findAll();
	}

	public Seat deleteSeatById(int SeatId) {
		Seat Seat = fetchSeatById(SeatId);
		seatRepo.delete(Seat);
		return Seat;
	}

	public Seat updateSeatById(int oldSeatId, Seat newSeat) {
		newSeat.setSeatId(oldSeatId);
		return saveSeat(newSeat);
	}
}
