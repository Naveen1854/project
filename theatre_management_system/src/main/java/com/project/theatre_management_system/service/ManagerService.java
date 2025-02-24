package com.project.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.theatre_management_system.dao.ManagerDao;
import com.project.theatre_management_system.dto.Manager;
import com.project.theatre_management_system.exception.ManagerIdNotFound;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

@Service
public class ManagerService {
	@Autowired
	ManagerDao managerDao;
	
	@Autowired
	ResponseStructure<Manager> responseStructure;
	
	@Autowired
	ResponseStructureList<Manager> responseStructureList;

	public ResponseStructure<Manager> saveManager(Manager manager) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully saved the Manager into db");
		responseStructure.setData(managerDao.saveManager(manager));
		return responseStructure;
	}
	
	public ResponseStructure<Manager> fetchManagerById(int managerId) {
		Manager manager = managerDao.fetchManagerById(managerId);
		if (manager != null) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfullyg Manager fetched By Id");
		responseStructure.setData(managerDao.fetchManagerById(managerId));
		return responseStructure;
		}else {
			throw new ManagerIdNotFound();
		}
	}
	
	public ResponseStructureList<Manager> fetchAllManager(){
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Succesfully AllManager fetched from db");
		responseStructureList.setData(managerDao.fetchAllManager());
		return responseStructureList;
	}
	
	public ResponseStructure<Manager> deleteManagerById(int managerId) {
		Manager manager = managerDao.fetchManagerById(managerId);
		if (manager != null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Succesfully Manager deleated by id from db");
		responseStructure.setData(managerDao.deleteManagerById(managerId));
		return responseStructure;
		}else {
			throw new ManagerIdNotFound();
		}
	}
	
	public ResponseStructure<Manager> updateManagerById(int oldManager, Manager newManger) {
		Manager manager = managerDao.fetchManagerById(oldManager);
		if(manager != null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Succesfully Manager updated by id in db");
		responseStructure.setData(managerDao.updateManagerById(oldManager, newManger));
		return responseStructure;
		}else {
			throw new ManagerIdNotFound();
		}
	}
}
