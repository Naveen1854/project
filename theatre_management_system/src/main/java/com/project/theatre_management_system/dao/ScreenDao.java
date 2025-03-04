package com.project.theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

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

	public Screen saveScreen(Screen screen) {
		return screenRepo.save(screen);
	}

	public Screen addExistingSeatToExistingScreen(int seatId, int screenId) {
		Seat seat = seatDao.fetchSeatById(seatId);
		Screen screen = fetchScreenById(screenId);
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

	public Screen fetchScreenById(int screenId) {
		Optional<Screen> dbScreen = screenRepo.findById(screenId);
		if (dbScreen.isEmpty())
			return null;
		return dbScreen.get();
	}

	public List<Screen> fetchAllScreen() {
		return screenRepo.findAll();
	}

	public Screen deleteScreenById(int screenId) {
		Screen screen = fetchScreenById(screenId);
		screenRepo.delete(screen);
		return screen;
	}

	public Screen updateScreenById(int oldScreenId, Screen newScreen) {
		newScreen.setScreenId(oldScreenId);
		return saveScreen(newScreen);
	}
}
