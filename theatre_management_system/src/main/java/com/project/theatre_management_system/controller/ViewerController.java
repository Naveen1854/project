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

import com.project.theatre_management_system.dto.Viewer;
import com.project.theatre_management_system.service.ViewerService;

@RestController
public class ViewerController {

	@Autowired
	ViewerService viewerService;
	
	@PostMapping("/saveViewer")
	public Viewer saveViewer(@RequestBody Viewer viewer) {
		return viewerService.saveViewer(viewer);
	}
	
	@GetMapping("/fetchViewerById")
	public Viewer fetchViewerById(@RequestParam int viewerId) {
		return viewerService.fetchViewerById(viewerId);
	}
	
	@GetMapping("/fetchAllViewer")
	public List<Viewer> fetchAllViewer() {
		return viewerService.fetchAllViewer();
	}
	
	@DeleteMapping("/deleteViewerById")
	public Viewer deleteViewerById(@RequestParam int viewerId) {
		return viewerService.deleteViewerById(viewerId);
	}
	
	@PutMapping("/updateViewerById")
	public Viewer updateViewerById(@RequestParam int oldViewerId, @RequestBody Viewer newViewer) {
		return viewerService.updateViewerById(oldViewerId, newViewer);
	}
	
	@PutMapping("/addExistingSeatToExistingViewer")
	public Viewer addExistingSeatToExistingViewer(@RequestParam int seatId, @RequestParam int viewerId) {
		return viewerService.addExistingSeatToExistingViewer(seatId, viewerId);
	}
}
