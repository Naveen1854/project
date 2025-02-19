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

import com.project.theatre_management_system.dto.Branch;
import com.project.theatre_management_system.dto.Owner;
import com.project.theatre_management_system.dto.Screen;
import com.project.theatre_management_system.dto.Staff;
import com.project.theatre_management_system.service.BranchService;

@RestController
public class BranchController {
	@Autowired
	BranchService branchService;

	@PostMapping("/saveBranch")
	public Branch saveBranch(@RequestBody Branch branch) {
		return branchService.saveBranch(branch);
	}

	@GetMapping("/fetchBranchById")
	public Branch fetchBranchById(@RequestParam int branchId) {
		return branchService.fetchBranchById(branchId);
	}

	@GetMapping("/fetchAllBranch")
	public List<Branch> fetchAllBranch() {
		return branchService.fetchAllBranch();
	}

	@DeleteMapping("/deleteBranchById")
	public Branch deleteBranchById(@RequestParam int branchId) {
		return branchService.deleteBranchById(branchId);
	}

	@PutMapping("/updateBranchById")
	public Branch updateBranchById(@RequestParam int oldBranchId, @RequestBody Branch newBranch) {
		return branchService.updateBranchById(oldBranchId, newBranch);
	}

	@PutMapping("/addExistingManagerToExistingBranch")
	public Branch addExistingManagerToExistingBranch(@RequestParam int managerId, @RequestParam int branchId) {
		return branchService.addExistingManagerToExistingBranch(managerId, branchId);
	}

	@PutMapping("/addExistingAddressToExistingBranch")
	public Branch addExistingAddressToExistingBranch(@RequestParam int addressId, @RequestParam int branchId) {
		return branchService.addExistingAddressToExistingBranch(addressId, branchId);
	}

	@PutMapping("/addExistingStaffToExistingBranch")
	public Branch addExistingStaffToExistingBranch(@RequestParam int staffId, @RequestParam int branchId) {
		return branchService.addExistingStaffToExistingBranch(staffId, branchId);
	}
	
	@PostMapping("/addNewStaffToExistingBranch")
	public Branch addNewStaffToExistingBranch(@RequestParam int branchId, @RequestBody Staff newStaff) {
		return branchService.addNewStaffToExistingBranch(branchId, newStaff);
	}
	
	@PutMapping("/addExistingScreenToExistingBranch")
	public Branch addExistingScreenToExistingBranch(@RequestParam int screenId, @RequestParam int branchId) {
		return branchService.addExistingScreenToExistingBranch(screenId, branchId);
	}
	
	@PostMapping("/addNewScreenToExistingBranch")
	public Branch addNewScreenToExistingBranch(@RequestParam int branchId, @RequestBody Screen newScreen) {
		return branchService.addNewScreenToExistingBranch(branchId, newScreen);
	}
}
