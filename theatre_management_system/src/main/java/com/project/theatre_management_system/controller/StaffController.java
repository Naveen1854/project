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

import com.project.theatre_management_system.dto.Staff;
import com.project.theatre_management_system.service.StaffService;

@RestController
public class StaffController {

	@Autowired
	StaffService staffService;
	
	@PostMapping("/saveStaff")
	public Staff saveStaff(@RequestBody Staff staff) {
		return staffService.saveStaff(staff);
	}
	
	@GetMapping("/fetchStaffById")
	public Staff fetchStaffById(@RequestParam int staffId) {
		return staffService.fetchStaffById(staffId);
	}
	
	@GetMapping("/fetchAllStaff")
	public List<Staff> fetchAllStaff() {
		return staffService.fetchAllStaff();
	}
	
	@DeleteMapping("/deleteStaffById")
	public Staff deleteStaffById(@RequestParam int staffId) {
		return staffService.deleteStaffById(staffId);
	}
	
	@PutMapping("/updateStaffById")
	public Staff updateStaffById(@RequestParam int oldStaffId, @RequestBody Staff newStaff) {
		return staffService.updateStaffById(oldStaffId, newStaff);
	}
}
