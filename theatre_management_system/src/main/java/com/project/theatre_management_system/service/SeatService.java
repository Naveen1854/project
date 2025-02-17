package com.project.theatre_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.theatre_management_system.dao.SeatDao;
import com.project.theatre_management_system.dto.Seat;

@Service
public class SeatService {

	@Autowired
	SeatDao seatDao;
	
	public Seat saveSeat(Seat Seat) {
		return seatDao.saveSeat(Seat);
	}
	
	public Seat fetchSeatById(int SeatId) {
		return seatDao.fetchSeatById(SeatId);
	}
	
	public List<Seat> fetchAllSeat() {
		return seatDao.fetchAllSeat();
	}
	
	public Seat deleteSeatById(int SeatId) {
		return seatDao.deleteSeatById(SeatId);
	}
	
	public Seat updateSeatById(int oldSeatId, Seat newSeat) {
		return seatDao.updateSeatById(oldSeatId, newSeat);
	}
}
