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

import com.project.theatre_management_system.dto.Manager;
import com.project.theatre_management_system.service.ManagerService;

@RestController
public class ManagerController {
	@Autowired
	ManagerService managerService;

	@PostMapping("/saveManager")
	public Manager saveManager(@RequestBody Manager manager) {
		return managerService.saveManager(manager);
	}

	@GetMapping("/fetchManagerById")
	public Manager fetchManagerById(@RequestParam int managerId) {
		return managerService.fetchManagerById(managerId);
	}

	@GetMapping("/fetchAllManager")
	public List<Manager> fetchAllManager() {
		return managerService.fetchAllManager();
	}

	@DeleteMapping("/deleteManagerById")
	public Manager deleteManagerById(@RequestParam int managerId) {
		return managerService.deleteManagerById(managerId);
	}

	@PutMapping("/updateManagerById")
	public Manager updateManagerById(@RequestParam int oldManagerId, @RequestBody Manager newManager) {
		return managerService.updateManagerById(oldManagerId, newManager);
	}
}
