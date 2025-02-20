package com.project.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.theatre_management_system.dao.ScreenDao;
import com.project.theatre_management_system.dto.Screen;
import com.project.theatre_management_system.dto.Seat;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

@Service
public class ScreenService {
	@Autowired
	ScreenDao serviceDao;
	
	@Autowired
	ResponseStructure<Screen> responseStructure;
	
	@Autowired
	ResponseStructureList<Screen> responseStructureList;
	
	public ResponseStructure<Screen> saveScreen(Screen screen) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Succesfully Saved the Owner into db");
		responseStructure.setData(serviceDao.saveScreen(screen));
		return responseStructure;
	}
	
	public ResponseStructure<Screen> addExistingSeatToExistingScreen(int seatId, int ScreenId) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Succesfully Saved the Owner into db");
		responseStructure.setData(serviceDao.addExistingSeatToExistingScreen(seatId, ScreenId));
		return responseStructure; 
	}
	
	public ResponseStructure<Screen> addNewSeatToExistingScreen(int screenId, Seat newSeat) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Succesfully Saved the Owner into db");
		responseStructure.setData(serviceDao.addNewSeatToExistingScreen(screenId, newSeat));
		return responseStructure;
	}
	
	public ResponseStructure<Screen> fetchScreenById(int screenId) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Owner successfully fetched from db");
		responseStructure.setData(serviceDao.fetchScreenById(screenId));
		return responseStructure;
	}
	
	public ResponseStructureList<Screen> fetchAllScreen() {
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Succesfully Address fetched by id from db");
		responseStructureList.setData(serviceDao.fetchAllScreen());
		return responseStructureList;
	}
	
	public ResponseStructure<Screen> deleteScreenById(int screenId) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Succesfully Address fetched by id from db");
		responseStructure.setData(serviceDao.deleteScreenById(screenId));
		return responseStructure;
	}
	
	public ResponseStructure<Screen> updateScreenById(int oldScreenId, Screen newScreen) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Succesfully Address fetched by id from db");
		responseStructure.setData(serviceDao.updateScreenById(oldScreenId, newScreen));
		return responseStructure;
	}
}
