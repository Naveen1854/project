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

import com.project.theatre_management_system.dto.Owner;
import com.project.theatre_management_system.service.OwnerService;

@RestController
public class OwnerController {
	@Autowired
	OwnerService ownerService;
	
	@PostMapping("/saveOwner")
	public Owner saveOwner(@RequestBody Owner owner) {
		return ownerService.saveOwner(owner);
	}
	
	@GetMapping("/fetchOwnweById")
	public Owner fetchOwnerById(@RequestParam int ownerId) {
		return ownerService.fetchOwnerById(ownerId);
	}
	
	@GetMapping("/fetchAllOwner")
	public List<Owner> fetchAllOwner() {
		return ownerService.fetchAllOwner();
	}
	
	@DeleteMapping("/deleteOwnerById")
	public Owner deleteOwnerById(@RequestParam int ownerId) {
		return ownerService.deleteOwnerById(ownerId);
	}
	
	@PutMapping("/updateOwnerById")
	public Owner updateOwnerById(@RequestParam int oldOwnerId, @RequestBody Owner newOwner) {
		return ownerService.updateOwnerById(oldOwnerId, newOwner);
	}
	
	@PutMapping("/addExistingTheatreToExistingOwner")
	public Owner addExistingTheatreToExistingOwner(@RequestParam int theatreId, @RequestParam int ownerId) {
		return ownerService.addExistingTheatreToExistingOwner(theatreId, ownerId);
	}
}
