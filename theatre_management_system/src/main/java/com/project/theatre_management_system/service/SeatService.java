package com.project.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.theatre_management_system.dao.SeatDao;
import com.project.theatre_management_system.dto.Seat;
import com.project.theatre_management_system.exception.SeatIdNotFound;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

@Service
public class SeatService {

	@Autowired
	SeatDao seatDao;
	
	@Autowired
	ResponseStructure<Seat> responseStructure;
	
	@Autowired
	ResponseStructureList<Seat> responseStructureList;
	
	public ResponseStructure<Seat> saveSeat(Seat Seat) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Succesfully Saved the seat into db");
		responseStructure.setData(seatDao.saveSeat(Seat));
		return responseStructure;
	}
	
	public ResponseStructure<Seat> fetchSeatById(int SeatId) {
		Seat seat = seatDao.fetchSeatById(SeatId);
		if(seat != null) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Succesfully fetched the seat by id from db");
		responseStructure.setData(seatDao.fetchSeatById(SeatId));
		return responseStructure;
		}else {
			throw new SeatIdNotFound();
		}
	}
	
	public ResponseStructureList<Seat> fetchAllSeat() {
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Succesfully All seats fetched from db");
		responseStructureList.setData(seatDao.fetchAllSeat());
		return responseStructureList;
	}
	
	public ResponseStructure<Seat> deleteSeatById(int SeatId) {
		Seat seat = seatDao.fetchSeatById(SeatId);
		if(seat != null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Succesfully seat deleted by id from db");
		responseStructure.setData(seatDao.deleteSeatById(SeatId));
		return responseStructure;
		}else {
			throw new SeatIdNotFound();
		}
	}
	
	public ResponseStructure<Seat> updateSeatById(int oldSeatId, Seat newSeat) {
		Seat seat = seatDao.fetchSeatById(oldSeatId);
		if(seat != null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Succesfully seat updated by id in db");
		responseStructure.setData(seatDao.updateSeatById(oldSeatId, newSeat));
		return responseStructure;
		}else {
			throw new SeatIdNotFound();
		}
	}
}
