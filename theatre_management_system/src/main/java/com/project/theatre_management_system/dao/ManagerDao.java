package com.project.theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.theatre_management_system.dto.Manager;
import com.project.theatre_management_system.repo.ManagerRepo;

@Repository
public class ManagerDao {
	@Autowired
	ManagerRepo managerRepo;

	public Manager saveManager(Manager manager) {
		return managerRepo.save(manager);
	}

	public Manager fetchManagerById(int managerId) {
		Optional<Manager> dbManager = managerRepo.findById(managerId);
		if (dbManager.isEmpty())
			return null;
		return dbManager.get();
	}

	public List<Manager> fetchAllManager() {
		return managerRepo.findAll();
	}

	public Manager deleteManagerById(int managerId) {
		Manager manager = fetchManagerById(managerId);
		managerRepo.delete(manager);
		return manager;
	}

	public Manager updateManagerById(int oldManager, Manager newManger) {
		newManger.setManagerId(oldManager);
		return saveManager(newManger);
	}
}
