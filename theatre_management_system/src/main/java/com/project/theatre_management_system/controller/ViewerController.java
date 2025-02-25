package com.project.theatre_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.theatre_management_system.dto.Food;
import com.project.theatre_management_system.dto.Ticket;
import com.project.theatre_management_system.dto.Viewer;
import com.project.theatre_management_system.service.ViewerService;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class ViewerController {

	@Autowired
	ViewerService viewerService;

	@Operation(summary = "Save Viewer", description = "API is used to save the Viewer")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created") })
	@PostMapping("/saveViewer")
	public ResponseStructure<Viewer> saveViewer(@RequestBody Viewer viewer) {
		return viewerService.saveViewer(viewer);
	}

	@Operation(summary = "fetch Viewer", description = "API is used to fetch the Viewer")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully saved"),
			@ApiResponse(responseCode = "404", description = "Viewer not found for the given id") })
	@GetMapping("/fetchViewerById")
	public ResponseStructure<Viewer> fetchViewerById(@RequestParam int viewerId) {
		return viewerService.fetchViewerById(viewerId);
	}

	@Operation(summary = "fetch all Viewer", description = "API is used to fetch all the Viewer")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully fetched") })
	@GetMapping("/fetchAllViewer")
	public ResponseStructureList<Viewer> fetchAllViewer() {
		return viewerService.fetchAllViewer();
	}

	@Operation(summary = "delete Viewer", description = "API is used to delete the Viewer")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully deleted"),
			@ApiResponse(responseCode = "404", description = "Viewer not found for the given id") })
	@DeleteMapping("/deleteViewerById")
	public ResponseStructure<Viewer> deleteViewerById(@RequestParam int viewerId) {
		return viewerService.deleteViewerById(viewerId);
	}

	@Operation(summary = "update Viewer", description = "API is used to update the Viewer")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully updated"),
			@ApiResponse(responseCode = "404", description = "Viewer not found for the given id") })
	@PutMapping("/updateViewerById")
	public ResponseStructure<Viewer> updateViewerById(@RequestParam int oldViewerId, @RequestBody Viewer newViewer) {
		return viewerService.updateViewerById(oldViewerId, newViewer);
	}

	@Operation(summary = "add Existing Seat To Existing Viewer", description = "API is used to addExistingSeatToExistingViewer")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully added"),
			@ApiResponse(responseCode = "404", description = "Seat/Viewer not found for the given id") })
	@PutMapping("/addExistingSeatToExistingViewer")
	public ResponseStructure<Viewer> addExistingSeatToExistingViewer(@RequestParam int seatId,
			@RequestParam int viewerId) {
		return viewerService.addExistingSeatToExistingViewer(seatId, viewerId);
	}

	@Operation(summary = "add Existing Ticket To Existing Viewer", description = "API is used to addExistingTicketToExistingViewer")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully added"),
			@ApiResponse(responseCode = "404", description = "Ticket/Viewer not found for the given id") })
	@PutMapping("/addExistingTicketToExistingViewer")
	public ResponseStructure<Viewer> addExistingTicketToExistingViewer(@RequestParam int ticketId,
			@RequestParam int viewerId) {
		return viewerService.addExistingTicketToExistingViewer(ticketId, viewerId);
	}

	@Operation(summary = "add New Ticket To Existing Viewer", description = "API is used to addNewTicketToExistingViewer")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully added"),
			@ApiResponse(responseCode = "404", description = "Viewer/newTicket not found for the given id") })
	@PutMapping("/addNewTicketToExistingViewer")
	public ResponseStructure<Viewer> addNewTicketToExistingViewer(@RequestParam int viewerId,
			@RequestBody Ticket newTicket) {
		return viewerService.addNewTicketToExistingViewer(viewerId, newTicket);
	}

	@Operation(summary = "add Existing Food To Existing Viewer", description = "API is used to addExistingFoodToExistingViewer")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully added"),
			@ApiResponse(responseCode = "404", description = "Food/Viewer not found for the given id") })
	@PutMapping("/addExistingFoodToExistingViewer")
	public ResponseStructure<Viewer> addExistingFoodToExistingViewer(@RequestParam int foodId,
			@RequestParam int viewerId) {
		return viewerService.addExistingFoodToExistingViewer(foodId, viewerId);
	}

	@Operation(summary = "add New Food To Existing Viewer", description = "API is used to addNewFoodToExistingViewer")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully added"),
			@ApiResponse(responseCode = "404", description = "Viewer/newFood not found for the given id") })
	@PutMapping("/addNewFoodToExistingViewer")
	public ResponseStructure<Viewer> addNewFoodToExistingViewer(@RequestParam int viewerId, @RequestBody Food newFood) {
		return viewerService.addNewFoodToExistingViewer(viewerId, newFood);
	}
}
