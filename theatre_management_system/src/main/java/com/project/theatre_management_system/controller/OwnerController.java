package com.project.theatre_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.theatre_management_system.dto.Owner;
import com.project.theatre_management_system.service.OwnerService;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

@RestController
public class OwnerController {
	@Autowired
	OwnerService ownerService;

	@PostMapping("/saveOwner")
	public ResponseStructure<Owner> saveOwner(@RequestBody Owner owner) {
		return ownerService.saveOwner(owner);
	}

	@GetMapping("/fetchOwnweById")
	public ResponseStructure<Owner> fetchOwnerById(@RequestParam int ownerId) {
		return ownerService.fetchOwnerById(ownerId);
	}

	@GetMapping("/fetchAllOwner")
	public ResponseStructureList<Owner> fetchAllOwner() {
		return ownerService.fetchAllOwner();
	}

	@DeleteMapping("/deleteOwnerById")
	public ResponseStructure<Owner> deleteOwnerById(@RequestParam int ownerId) {
		return ownerService.deleteOwnerById(ownerId);
	}

	@PutMapping("/updateOwnerById")
	public ResponseStructure<Owner> updateOwnerById(@RequestParam int oldOwnerId, @RequestBody Owner newOwner) {
		return ownerService.updateOwnerById(oldOwnerId, newOwner);
	}

	@PutMapping("/addExistingTheatreToExistingOwner")
	public ResponseStructure<Owner> addExistingTheatreToExistingOwner(@RequestParam int theatreId,
			@RequestParam int ownerId) {
		return ownerService.addExistingTheatreToExistingOwner(theatreId, ownerId);
	}
}
