package com.project.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.theatre_management_system.dao.ScreenDao;
import com.project.theatre_management_system.dto.Screen;
import com.project.theatre_management_system.dto.Seat;
import com.project.theatre_management_system.exception.ScreenIdNotFound;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

@Service
public class ScreenService {
	@Autowired
	ScreenDao screenDao;

	@Autowired
	ResponseStructure<Screen> responseStructure;

	@Autowired
	ResponseStructureList<Screen> responseStructureList;

	public ResponseStructure<Screen> saveScreen(Screen screen) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Succesfully Saved the Screen into db");
		responseStructure.setData(screenDao.saveScreen(screen));
		return responseStructure;
	}

	public ResponseStructure<Screen> addExistingSeatToExistingScreen(int seatId, int ScreenId) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Succesfully added existing seat to existing Screen into db");
		responseStructure.setData(screenDao.addExistingSeatToExistingScreen(seatId, ScreenId));
		return responseStructure;
	}

	public ResponseStructure<Screen> addNewSeatToExistingScreen(int screenId, Seat newSeat) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Succesfully added new seat to existing screen into db");
		responseStructure.setData(screenDao.addNewSeatToExistingScreen(screenId, newSeat));
		return responseStructure;
	}

	public ResponseStructure<Screen> fetchScreenById(int screenId) {
		Screen screen = screenDao.fetchScreenById(screenId);
		if (screen != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("screen successfully fetched by id from db");
			responseStructure.setData(screenDao.fetchScreenById(screenId));
			return responseStructure;
		} else {
			throw new ScreenIdNotFound();
		}
	}

	public ResponseStructureList<Screen> fetchAllScreen() {
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Succesfully fetched all screens from db");
		responseStructureList.setData(screenDao.fetchAllScreen());
		return responseStructureList;
	}

	public ResponseStructure<Screen> deleteScreenById(int screenId) {
		Screen screen = screenDao.fetchScreenById(screenId);
		if (screen != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Succesfully deleted screen by id from db");
			responseStructure.setData(screenDao.deleteScreenById(screenId));
			return responseStructure;
		} else {
			throw new ScreenIdNotFound();
		}
	}

	public ResponseStructure<Screen> updateScreenById(int oldScreenId, Screen newScreen) {
		Screen screen = screenDao.fetchScreenById(oldScreenId);
		if (screen != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Succesfully updated screen by id in db");
			responseStructure.setData(screenDao.updateScreenById(oldScreenId, newScreen));
			return responseStructure;
		} else {
			throw new ScreenIdNotFound();
		}
	}
}
