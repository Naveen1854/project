package com.project.theatre_management_system.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.theatre_management_system.dto.Staff;
import com.project.theatre_management_system.repo.StaffRepo;

@Repository
public class StaffDao {
	@Autowired
	StaffRepo staffRepo;
	
	public Staff saveStaff(Staff staff) {
		return staffRepo.save(staff);
	}
	
	public Staff fetchStaffById(int staffId) {
		return staffRepo.findById(staffId).get();
	}
	
	public List<Staff> fetchAllStaff() {
		return staffRepo.findAll();
	}
	
	public Staff deleteStaffById(int staffId) {
		Staff staff = fetchStaffById(staffId);
		staffRepo.delete(staff);
		return staff;
	}
	
	public Staff updateStaffById(int oldStaffId, Staff newStaff) {
		newStaff.setStaffId(oldStaffId);
		return saveStaff(newStaff);
	}
}
