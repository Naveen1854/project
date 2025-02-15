package com.project.theatre_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.theatre_management_system.dao.ManagerDao;
import com.project.theatre_management_system.dto.Manager;

@Service
public class ManagerService {
	@Autowired
	ManagerDao managerDao;

	public Manager saveManager(Manager manager) {
		return managerDao.saveManager(manager);
	}
	
	public Manager fetchManagerById(int managerId) {
		return managerDao.fetchManagerById(managerId);
	}
	
	public List<Manager> fetchAllManager(){
		return managerDao.fetchAllManager();
	}
	
	public Manager deleteManagerById(int managerId) {
		return managerDao.deleteManagerById(managerId);
	}
	
	public Manager updateManagerById(int oldManager, Manager newManger) {
		return managerDao.updateManagerById(oldManager, newManger);
	}
}
