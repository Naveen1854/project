package com.project.theatre_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.theatre_management_system.dto.Staff;
import com.project.theatre_management_system.service.StaffService;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class StaffController {

	@Autowired
	StaffService staffService;

	@Operation(summary = "Save Seat", description = "API is used to save the Staff")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created") })
	@PostMapping("/saveStaff")
	public ResponseStructure<Staff> saveStaff(@RequestBody Staff staff) {
		return staffService.saveStaff(staff);
	}

	@Operation(summary = "fetch Staff", description = "API is used to fetch the Staff")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully saved"),
			@ApiResponse(responseCode = "404", description = "Staff not found for the given id") })
	@GetMapping("/fetchStaffById")
	public ResponseStructure<Staff> fetchStaffById(@RequestParam int staffId) {
		return staffService.fetchStaffById(staffId);
	}

	@Operation(summary = "fetch all Staff", description = "API is used to fetch all the Staff")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully fetched") })
	@GetMapping("/fetchAllStaff")
	public ResponseStructureList<Staff> fetchAllStaff() {
		return staffService.fetchAllStaff();
	}

	@Operation(summary = "delete Staff", description = "API is used to delete the Staff")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully deleted"),
			@ApiResponse(responseCode = "404", description = "Staff not found for the given id") })
	@DeleteMapping("/deleteStaffById")
	public ResponseStructure<Staff> deleteStaffById(@RequestParam int staffId) {
		return staffService.deleteStaffById(staffId);
	}

	@Operation(summary = "update Staff", description = "API is used to update the Staff")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully updated"),
			@ApiResponse(responseCode = "404", description = "Staff not found for the given id") })
	@PutMapping("/updateStaffById")
	public ResponseStructure<Staff> updateStaffById(@RequestParam int oldStaffId, @RequestBody Staff newStaff) {
		return staffService.updateStaffById(oldStaffId, newStaff);
	}
}
