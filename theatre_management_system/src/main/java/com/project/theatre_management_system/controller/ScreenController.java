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

import com.project.theatre_management_system.dto.Screen;
import com.project.theatre_management_system.service.ScreenService;

@RestController
public class ScreenController {

	@Autowired
	ScreenService screenService;
	
	@PostMapping("/saveScreen")
	public Screen saveScreen(@RequestBody Screen screen) {
		return screenService.saveScreen(screen);
	}
	
	@GetMapping("/fetchScreenById")
	public Screen fetchScreenById(@RequestParam int screenId) {
		return screenService.fetchScreenById(screenId);
	}
	
	@GetMapping("/fetchAllScreen")
	public List<Screen> fetchAllScreen() {
		return screenService.fetchAllScreen();
	}
	
	@DeleteMapping("/deleteScreenById")
	public Screen deleteScreenById(@RequestParam int screenId) {
		return screenService.deleteScreenById(screenId);
	}
	
	@PutMapping("/updateScreenById")
	public Screen updateScreenById(@RequestParam int oldScreend, @RequestBody Screen newScreen) {
		return screenService.updateScreenById(oldScreend, newScreen);
	}
}
