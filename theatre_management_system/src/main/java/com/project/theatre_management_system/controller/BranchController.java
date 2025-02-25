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
import com.project.theatre_management_system.dto.Screen;
import com.project.theatre_management_system.dto.Staff;
import com.project.theatre_management_system.service.BranchService;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class BranchController {
	@Autowired
	BranchService branchService;

	@Operation(summary = "Save Branch", description = "API is used to save the Branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created") })
	@PostMapping("/saveBranch")
	public ResponseStructure<Branch> saveBranch(@RequestBody Branch branch) {
		return branchService.saveBranch(branch);
	}

	@Operation(summary = "fetch Branch", description = "API is used to fetch the Branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully saved"),
			@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })
	@GetMapping("/fetchBranchById")
	public ResponseStructure<Branch> fetchBranchById(@RequestParam int branchId) {
		return branchService.fetchBranchById(branchId);
	}

	@Operation(summary = "fetch all Branch", description = "API is used to fetch all the Branches")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully fetched") })
	@GetMapping("/fetchAllBranch")
	public ResponseStructureList<Branch> fetchAllBranch() {
		return branchService.fetchAllBranch();
	}

	@Operation(summary = "delete Branch", description = "API is used to delete the Branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully deleted"),
			@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })
	@DeleteMapping("/deleteBranchById")
	public ResponseStructure<Branch> deleteBranchById(@RequestParam int branchId) {
		return branchService.deleteBranchById(branchId);
	}

	@Operation(summary = "update Branch", description = "API is used to update the Branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully updated"),
			@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })
	@PutMapping("/updateBranchById")
	public ResponseStructure<Branch> updateBranchById(@RequestParam int oldBranchId, @RequestBody Branch newBranch) {
		return branchService.updateBranchById(oldBranchId, newBranch);
	}

	@Operation(summary = "Add Existing Manager To Existing Branch", description = "API is used to addExistingManagerToExistingBranch")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Successfully addExistingManagerToExistingBranch"),
			@ApiResponse(responseCode = "404", description = "Manager/Branch not found for the given id") })
	@PutMapping("/addExistingManagerToExistingBranch")
	public ResponseStructure<Branch> addExistingManagerToExistingBranch(@RequestParam int managerId,
			@RequestParam int branchId) {
		return branchService.addExistingManagerToExistingBranch(managerId, branchId);
	}

	@Operation(summary = "Add Existing Address To Existing Branch", description = "API is used to addExistingAddressToExistingBranch")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Successfully addExistingAddressToExistingBranch"),
			@ApiResponse(responseCode = "404", description = "Address/Branch not found for the given id") })
	@PutMapping("/addExistingAddressToExistingBranch")
	public ResponseStructure<Branch> addExistingAddressToExistingBranch(@RequestParam int addressId,
			@RequestParam int branchId) {
		return branchService.addExistingAddressToExistingBranch(addressId, branchId);
	}

	@Operation(summary = "Add Existing Staff To Existing Branch", description = "API is used to addExistingStaffToExistingBranch")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Successfully addExistingStaffToExistingBranch"),
			@ApiResponse(responseCode = "404", description = "Staff/Branch not found for the given id") })
	@PutMapping("/addExistingStaffToExistingBranch")
	public ResponseStructure<Branch> addExistingStaffToExistingBranch(@RequestParam int staffId,
			@RequestParam int branchId) {
		return branchService.addExistingStaffToExistingBranch(staffId, branchId);
	}

	@Operation(summary = "Add New Staff To Existing Branch", description = "API is used to addNewStaffToExistingBranch")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Successfully addNewStaffToExistingBranch"),
			@ApiResponse(responseCode = "404", description = "Branch/newStaff not found for the given id") })
	@PutMapping("/addNewStaffToExistingBranch")
	public ResponseStructure<Branch> addNewStaffToExistingBranch(@RequestParam int branchId,
			@RequestBody Staff newStaff) {
		return branchService.addNewStaffToExistingBranch(branchId, newStaff);
	}

	@Operation(summary = "Add Existing Screen To Existing Branch", description = "API is used to addExistingScreenToExistingBranch")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Successfully addExistingScreenToExistingBranch"),
			@ApiResponse(responseCode = "404", description = "Screen/Branch not found for the given id") })
	@PutMapping("/addExistingScreenToExistingBranch")
	public ResponseStructure<Branch> addExistingScreenToExistingBranch(@RequestParam int screenId,
			@RequestParam int branchId) {
		return branchService.addExistingScreenToExistingBranch(screenId, branchId);
	}

	@Operation(summary = "Add New Screen To Existing Branch", description = "API is used to addNewScreenToExistingBranch")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Successfully addNewScreenToExistingBranch"),
			@ApiResponse(responseCode = "404", description = "Branch/newScreen not found for the given id") })
	@PutMapping("/addNewScreenToExistingBranch")
	public ResponseStructure<Branch> addNewScreenToExistingBranch(@RequestParam int branchId,
			@RequestBody Screen newScreen) {
		return branchService.addNewScreenToExistingBranch(branchId, newScreen);
	}
}
