package com.project.theatre_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class OwnerController {
	@Autowired
	OwnerService ownerService;

	@Operation(summary = "Save Owner", description = "API is used to save the Owner")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created") })
	@PostMapping("/saveOwner")
	public ResponseEntity<ResponseStructure<Owner>> saveOwner(@RequestBody Owner owner) {
		return ownerService.saveOwner(owner);
	}

	@Operation(summary = "fetch Owner", description = "API is used to fetch the Owner")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully saved"),
			@ApiResponse(responseCode = "404", description = "Owner not found for the given id") })
	@GetMapping("/fetchOwnweById")
	public ResponseEntity<ResponseStructure<Owner>> fetchOwnerById(@RequestParam int ownerId) {
		return ownerService.fetchOwnerById(ownerId);
	}

	@Operation(summary = "fetch all Owner", description = "API is used to fetch all the Owners")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully fetched") })
	@GetMapping("/fetchAllOwner")
	public ResponseEntity<ResponseStructureList<Owner>> fetchAllOwner() {
		return ownerService.fetchAllOwner();
	}

	@Operation(summary = "delete Owner", description = "API is used to delete the Owner")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully deleted"),
			@ApiResponse(responseCode = "404", description = "Owner not found for the given id") })
	@DeleteMapping("/deleteOwnerById")
	public ResponseEntity<ResponseStructure<Owner>> deleteOwnerById(@RequestParam int ownerId) {
		return ownerService.deleteOwnerById(ownerId);
	}

	@Operation(summary = "update Owner", description = "API is used to update the Owner")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully updated"),
			@ApiResponse(responseCode = "404", description = "Owner not found for the given id") })
	@PutMapping("/updateOwnerById")
	public ResponseEntity<ResponseStructure<Owner>> updateOwnerById(@RequestParam int oldOwnerId,
			@RequestBody Owner newOwner) {
		return ownerService.updateOwnerById(oldOwnerId, newOwner);
	}

	@Operation(summary = "add Existing Theatre To Existing Owner", description = "API is used to add Existing Theatre To Existing Owner")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully added"),
			@ApiResponse(responseCode = "404", description = "Owner/theatre not found for the given id") })
	@PutMapping("/addExistingTheatreToExistingOwner")
	public ResponseEntity<ResponseStructure<Owner>> addExistingTheatreToExistingOwner(@RequestParam int theatreId,
			@RequestParam int ownerId) {
		return ownerService.addExistingTheatreToExistingOwner(theatreId, ownerId);
	}
}
