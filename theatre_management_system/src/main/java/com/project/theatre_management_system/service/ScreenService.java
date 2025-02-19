package com.project.theatre_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.theatre_management_system.dao.ScreenDao;
import com.project.theatre_management_system.dto.Screen;
import com.project.theatre_management_system.dto.Seat;

@Service
public class ScreenService {
	@Autowired
	ScreenDao serviceDao;
	
	public Screen saveScreen(Screen screen) {
		return serviceDao.saveScreen(screen);
	}
	
	public Screen addExistingSeatToExistingScreen(int seatId, int ScreenId) {
		return serviceDao.addExistingSeatToExistingScreen(seatId, ScreenId);
	}
	
	public Screen addNewSeatToExistingScreen(int screenId, Seat newSeat) {
		return serviceDao.addNewSeatToExistingScreen(screenId, newSeat);
	}
	
	public Screen fetchScreenById(int screenId) {
		return serviceDao.fetchScreenById(screenId);
	}
	
	public List<Screen> fetchAllScreen() {
		return serviceDao.fetchAllScreen();
	}
	
	public Screen deleteScreenById(int screenId) {
		return serviceDao.deleteScreenById(screenId);
	}
	
	public Screen updateScreenById(int oldScreenId, Screen newScreen) {
		return serviceDao.updateScreenById(oldScreenId, newScreen);
	}
}
