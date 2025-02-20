package com.project.theatre_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.theatre_management_system.dto.Screen;
import com.project.theatre_management_system.dto.Seat;
import com.project.theatre_management_system.service.ScreenService;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

@RestController
public class ScreenController {

	@Autowired
	ScreenService screenService;

	@PostMapping("/saveScreen")
	public ResponseStructure<Screen> saveScreen(@RequestBody Screen screen) {
		return screenService.saveScreen(screen);
	}

	@GetMapping("/fetchScreenById")
	public ResponseStructure<Screen> fetchScreenById(@RequestParam int screenId) {
		return screenService.fetchScreenById(screenId);
	}

	@GetMapping("/fetchAllScreen")
	public ResponseStructureList<Screen> fetchAllScreen() {
		return screenService.fetchAllScreen();
	}

	@DeleteMapping("/deleteScreenById")
	public ResponseStructure<Screen> deleteScreenById(@RequestParam int screenId) {
		return screenService.deleteScreenById(screenId);
	}

	@PutMapping("/updateScreenById")
	public ResponseStructure<Screen> updateScreenById(@RequestParam int oldScreend, @RequestBody Screen newScreen) {
		return screenService.updateScreenById(oldScreend, newScreen);
	}

	@PutMapping("/addExistingSeatToExistingScreen")
	public ResponseStructure<Screen> addExistingSeatToExistingScreen(@RequestParam int seatId,
			@RequestParam int ScreenId) {
		return screenService.addExistingSeatToExistingScreen(seatId, ScreenId);
	}

	@PostMapping("/addNewSeatToExistingScreen")
	public ResponseStructure<Screen> addNewSeatToExistingScreen(@RequestParam int screenId, @RequestBody Seat newSeat) {
		return screenService.addNewSeatToExistingScreen(screenId, newSeat);
	}
}
