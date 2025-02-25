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

import com.project.theatre_management_system.dto.Manager;
import com.project.theatre_management_system.service.ManagerService;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class ManagerController {
	@Autowired
	ManagerService managerService;

	@Operation(summary = "Save Manager", description = "API is used to save the Manager")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created") })
	@PostMapping("/saveManager")
	public ResponseEntity<ResponseStructure<Manager>> saveManager(@RequestBody Manager manager) {
		return managerService.saveManager(manager);
	}

	@Operation(summary = "fetch Manager", description = "API is used to fetch the Manager")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully saved"),
			@ApiResponse(responseCode = "404", description = "Manager not found for the given id") })
	@GetMapping("/fetchManagerById")
	public ResponseEntity<ResponseStructure<Manager>> fetchManagerById(@RequestParam int managerId) {
		return managerService.fetchManagerById(managerId);
	}

	@Operation(summary = "fetch all Manager", description = "API is used to fetch all the Managers")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully fetched") })
	@GetMapping("/fetchAllManager")
	public ResponseEntity<ResponseStructureList<Manager>> fetchAllManager() {
		return managerService.fetchAllManager();
	}

	@Operation(summary = "delete Manager", description = "API is used to delete the Manager")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully deleted"),
			@ApiResponse(responseCode = "404", description = "Manager not found for the given id") })
	@DeleteMapping("/deleteManagerById")
	public ResponseEntity<ResponseStructure<Manager>> deleteManagerById(@RequestParam int managerId) {
		return managerService.deleteManagerById(managerId);
	}

	@Operation(summary = "update Manager", description = "API is used to update the Manager")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully updated"),
			@ApiResponse(responseCode = "404", description = "Manager not found for the given id") })
	@PutMapping("/updateManagerById")
	public ResponseEntity<ResponseStructure<Manager>> updateManagerById(@RequestParam int oldManagerId,
			@RequestBody Manager newManager) {
		return managerService.updateManagerById(oldManagerId, newManager);
	}
}
