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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class ScreenController {

	@Autowired
	ScreenService screenService;

	@Operation(summary = "Save Screen", description = "API is used to save the Screen")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created") })
	@PostMapping("/saveScreen")
	public ResponseStructure<Screen> saveScreen(@RequestBody Screen screen) {
		return screenService.saveScreen(screen);
	}

	@Operation(summary = "fetch Screen", description = "API is used to fetch the Screen")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully saved"),
			@ApiResponse(responseCode = "404", description = "Screen not found for the given id") })
	@GetMapping("/fetchScreenById")
	public ResponseStructure<Screen> fetchScreenById(@RequestParam int screenId) {
		return screenService.fetchScreenById(screenId);
	}

	@Operation(summary = "fetch all Screen", description = "API is used to fetch all the Screens")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully fetched") })
	@GetMapping("/fetchAllScreen")
	public ResponseStructureList<Screen> fetchAllScreen() {
		return screenService.fetchAllScreen();
	}

	@Operation(summary = "delete Screen", description = "API is used to delete the Screen")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully deleted"),
			@ApiResponse(responseCode = "404", description = "Screen not found for the given id") })
	@DeleteMapping("/deleteScreenById")
	public ResponseStructure<Screen> deleteScreenById(@RequestParam int screenId) {
		return screenService.deleteScreenById(screenId);
	}

	@Operation(summary = "update Screen", description = "API is used to update the Screen")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully updated"),
			@ApiResponse(responseCode = "404", description = "Screen not found for the given id") })
	@PutMapping("/updateScreenById")
	public ResponseStructure<Screen> updateScreenById(@RequestParam int oldScreend, @RequestBody Screen newScreen) {
		return screenService.updateScreenById(oldScreend, newScreen);
	}

	@Operation(summary = "add Existing Seat To Existing Screen", description = "API is used to addExistingSeatToExistingScreen")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully added"),
			@ApiResponse(responseCode = "404", description = "Seat/Screen not found for the given id") })
	@PutMapping("/addExistingSeatToExistingScreen")
	public ResponseStructure<Screen> addExistingSeatToExistingScreen(@RequestParam int seatId,
			@RequestParam int ScreenId) {
		return screenService.addExistingSeatToExistingScreen(seatId, ScreenId);
	}

	@Operation(summary = "Add New Seat To Existing Screen", description = "API is used to addNewSeatToExistingScreen")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully added"),
			@ApiResponse(responseCode = "404", description = "Screen/newSeat not found for the given id") })
	@PostMapping("/addNewSeatToExistingScreen")
	public ResponseStructure<Screen> addNewSeatToExistingScreen(@RequestParam int screenId, @RequestBody Seat newSeat) {
		return screenService.addNewSeatToExistingScreen(screenId, newSeat);
	}
}
