package com.project.theatre_management_system.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.theatre_management_system.dto.Screen;
import com.project.theatre_management_system.dto.Seat;
import com.project.theatre_management_system.repo.ScreenRepo;

@Repository
public class ScreenDao {
	@Autowired
	ScreenRepo screenRepo;

	@Autowired
	SeatDao seatDao;

	public Screen saveScreen(Screen Screen) {
		return screenRepo.save(Screen);
	}

	public Screen addExistingSeatToExistingScreen(int seatId, int ScreenId) {
		Seat seat = seatDao.fetchSeatById(seatId);
		Screen screen = fetchScreenById(ScreenId);
		List<Seat> list = screen.getSeats();
		list.add(seat);
		screen.setSeats(list);
		return saveScreen(screen);
	}

	public Screen addNewSeatToExistingScreen(int screenId, Seat newSeat) {
		Screen screen = fetchScreenById(screenId);
		List<Seat> list = screen.getSeats();
		list.add(newSeat);
		screen.setSeats(list);
		return saveScreen(screen);
	}

	public Screen fetchScreenById(int ScreenId) {
		return screenRepo.findById(ScreenId).get();
	}

	public List<Screen> fetchAllScreen() {
		return screenRepo.findAll();
	}

	public Screen deleteScreenById(int ScreenId) {
		Screen Screen = deleteScreenById(ScreenId);
		screenRepo.delete(Screen);
		return Screen;
	}

	public Screen updateScreenById(int oldScreenId, Screen newScreen) {
		newScreen.setScreenId(oldScreenId);
		return saveScreen(newScreen);
	}
}
