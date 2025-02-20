package com.project.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.theatre_management_system.dao.StaffDao;
import com.project.theatre_management_system.dto.Staff;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

@Service
public class StaffService {

	@Autowired
	StaffDao staffDao;
	
	@Autowired
	ResponseStructure<Staff> responseStructure;
	
	@Autowired
	ResponseStructureList<Staff> responseStructureList;
	
	public ResponseStructure<Staff> saveStaff(Staff staff) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Succesfully Saved the Owner into db");
		responseStructure.setData(staffDao.saveStaff(staff));
		return responseStructure;
	}
	
	public ResponseStructure<Staff> fetchStaffById(int staffId) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Succesfully Saved the Owner into db");
		responseStructure.setData(staffDao.fetchStaffById(staffId));
		return responseStructure;
	}
	
	public ResponseStructureList<Staff> fetchAllStaff() {
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Succesfully Address fetched by id from db");
		responseStructureList.setData(staffDao.fetchAllStaff());
		return responseStructureList;
	}
	
	public ResponseStructure<Staff> deleteStaffById(int staffId) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Succesfully Address fetched by id from db");
		responseStructure.setData(staffDao.deleteStaffById(staffId));
		return responseStructure;
	}
	
	public ResponseStructure<Staff> updateStaffById(int oldStaffId, Staff newStaff) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Succesfully Address fetched by id from db");
		responseStructure.setData(staffDao.updateStaffById(oldStaffId, newStaff));
		return responseStructure;
	}
}
