package com.project.theatre_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.theatre_management_system.dao.StaffDao;
import com.project.theatre_management_system.dto.Staff;

@Service
public class StaffService {

	@Autowired
	StaffDao staffDao;
	
	public Staff saveStaff(Staff staff) {
		return staffDao.saveStaff(staff);
	}
	
	public Staff fetchStaffById(int staffId) {
		return staffDao.fetchStaffById(staffId);
	}
	
	public List<Staff> fetchAllStaff() {
		return staffDao.fetchAllStaff();
	}
	
	public Staff deleteStaffById(int staffId) {
		return staffDao.deleteStaffById(staffId);
	}
	
	public Staff updateStaffById(int oldStaffId, Staff newStaff) {
		return staffDao.updateStaffById(oldStaffId, newStaff);
	}
}
