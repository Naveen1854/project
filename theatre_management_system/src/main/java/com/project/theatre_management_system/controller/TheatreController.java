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

import com.project.theatre_management_system.dto.Branch;
import com.project.theatre_management_system.dto.Theatre;
import com.project.theatre_management_system.service.TheatreService;

@RestController
public class TheatreController {
	
	@Autowired
	TheatreService theatreService;
	
	@PostMapping("/saveTheatre")
	public Theatre saveTheatre(@RequestBody Theatre theatre) {
		return theatreService.saveTheatre(theatre);
	}
	
	@PutMapping("/addExistingBranchToExistingTheatre")
	public Theatre addExistingBranchToExistingTheatre(@RequestParam int branchId, @RequestParam int theatreId) {
		return theatreService.addExistingBranchToExistingTheatre(branchId, theatreId);
	}
	
	@PostMapping("/addNewBranchToExistingTheatre")
	public Theatre addNewBranchToExistingTheatre(@RequestParam int theatreId, @RequestBody Branch newBranch) {
		return theatreService.addNewBranchToExistingTheatre(theatreId, newBranch);
	}
	
	@GetMapping("/fetchTheatreById")
	public Theatre fetchTheatreById(@RequestParam int theatreId) {
		return theatreService.fetchTheatreById(theatreId);
	}
	
	@GetMapping("/fetchAllTheatre")
	public List<Theatre> fetchAllTheatre() {
		return theatreService.fetchAllTheatre();
	}
	
	@DeleteMapping("/deleteTheatreById")
	public Theatre deleteTheatreById(@RequestParam int theatreId) {
		return theatreService.deleteTheatreById(theatreId);
	}
	
	@PutMapping("/updateTheatreById")
	public Theatre updateTheatreById(@RequestParam int oldTheatreId, @RequestBody Theatre newTheatre) {
		return theatreService.updateTheatreById(oldTheatreId, newTheatre);
	}
}
