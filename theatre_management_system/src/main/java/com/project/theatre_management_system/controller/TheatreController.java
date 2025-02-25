package com.project.theatre_management_system.controller;

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
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class TheatreController {

	@Autowired
	TheatreService theatreService;

	@Operation(summary = "Save Theatre", description = "API is used to save the Theatre")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created") })
	@PostMapping("/saveTheatre")
	public ResponseStructure<Theatre> saveTheatre(@RequestBody Theatre theatre) {
		return theatreService.saveTheatre(theatre);
	}

	@Operation(summary = "add Existing Branch To Existing Theatre", description = "API is used to addExistingBranchToExistingTheatre")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully added"),
			@ApiResponse(responseCode = "404", description = "Branch/Theatre not found for the given id") })
	@PutMapping("/addExistingBranchToExistingTheatre")
	public ResponseStructure<Theatre> addExistingBranchToExistingTheatre(@RequestParam int branchId,
			@RequestParam int theatreId) {
		return theatreService.addExistingBranchToExistingTheatre(branchId, theatreId);
	}

	@Operation(summary = "add New Branch To Existing Theatre", description = "API is used to addNewBranchToExistingTheatre")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully added"),
			@ApiResponse(responseCode = "404", description = "Theatre/newBranch not found for the given id") })
	@PutMapping("/addNewBranchToExistingTheatre")
	public ResponseStructure<Theatre> addNewBranchToExistingTheatre(@RequestParam int theatreId,
			@RequestBody Branch newBranch) {
		return theatreService.addNewBranchToExistingTheatre(theatreId, newBranch);
	}

	@Operation(summary = "fetch Theatre", description = "API is used to fetch the Theatre")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully saved"),
			@ApiResponse(responseCode = "404", description = "Theatre not found for the given id") })
	@GetMapping("/fetchTheatreById")
	public ResponseStructure<Theatre> fetchTheatreById(@RequestParam int theatreId) {
		return theatreService.fetchTheatreById(theatreId);
	}

	@Operation(summary = "fetch all Theatre", description = "API is used to fetch all the Theatre")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully fetched") })
	@GetMapping("/fetchAllTheatre")
	public ResponseStructureList<Theatre> fetchAllTheatre() {
		return theatreService.fetchAllTheatre();
	}

	@Operation(summary = "delete Theatre", description = "API is used to delete the Theatre")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully deleted"),
			@ApiResponse(responseCode = "404", description = "Theatre not found for the given id") })
	@DeleteMapping("/deleteTheatreById")
	public ResponseStructure<Theatre> deleteTheatreById(@RequestParam int theatreId) {
		return theatreService.deleteTheatreById(theatreId);
	}

	@Operation(summary = "update Theatre", description = "API is used to update the Theatre")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully updated"),
			@ApiResponse(responseCode = "404", description = "Theatre not found for the given id") })
	@PutMapping("/updateTheatreById")
	public ResponseStructure<Theatre> updateTheatreById(@RequestParam int oldTheatreId,
			@RequestBody Theatre newTheatre) {
		return theatreService.updateTheatreById(oldTheatreId, newTheatre);
	}
}
