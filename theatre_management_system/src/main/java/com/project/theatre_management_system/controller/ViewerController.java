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

@RestController
public class ViewerController {

	@Autowired
	ViewerService viewerService;

	@PostMapping("/saveViewer")
	public ResponseStructure<Viewer> saveViewer(@RequestBody Viewer viewer) {
		return viewerService.saveViewer(viewer);
	}

	@GetMapping("/fetchViewerById")
	public ResponseStructure<Viewer> fetchViewerById(@RequestParam int viewerId) {
		return viewerService.fetchViewerById(viewerId);
	}

	@GetMapping("/fetchAllViewer")
	public ResponseStructureList<Viewer> fetchAllViewer() {
		return viewerService.fetchAllViewer();
	}

	@DeleteMapping("/deleteViewerById")
	public ResponseStructure<Viewer> deleteViewerById(@RequestParam int viewerId) {
		return viewerService.deleteViewerById(viewerId);
	}

	@PutMapping("/updateViewerById")
	public ResponseStructure<Viewer> updateViewerById(@RequestParam int oldViewerId, @RequestBody Viewer newViewer) {
		return viewerService.updateViewerById(oldViewerId, newViewer);
	}

	@PutMapping("/addExistingSeatToExistingViewer")
	public ResponseStructure<Viewer> addExistingSeatToExistingViewer(@RequestParam int seatId,
			@RequestParam int viewerId) {
		return viewerService.addExistingSeatToExistingViewer(seatId, viewerId);
	}

	@PutMapping("/addExistingTicketToExistingViewer")
	public ResponseStructure<Viewer> addExistingTicketToExistingViewer(@RequestParam int ticketId,
			@RequestParam int viewerId) {
		return viewerService.addExistingTicketToExistingViewer(ticketId, viewerId);
	}

	@PutMapping("/addNewTicketToExistingViewer")
	public ResponseStructure<Viewer> addNewTicketToExistingViewer(@RequestParam int viewerId,
			@RequestBody Ticket newTicket) {
		return viewerService.addNewTicketToExistingViewer(viewerId, newTicket);
	}

	@PutMapping("/addExistingFoodToExistingViewer")
	public ResponseStructure<Viewer> addExistingFoodToExistingViewer(@RequestParam int foodId,
			@RequestParam int viewerId) {
		return viewerService.addExistingFoodToExistingViewer(foodId, viewerId);
	}

	@PutMapping("/addNewFoodToExistingViewer")
	public ResponseStructure<Viewer> addNewFoodToExistingViewer(@RequestParam int viewerId, @RequestBody Food newFood) {
		return viewerService.addNewFoodToExistingViewer(viewerId, newFood);
	}
}
