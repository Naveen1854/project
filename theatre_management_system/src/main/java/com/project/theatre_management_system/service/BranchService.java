package com.project.theatre_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.theatre_management_system.dao.BranchDao;
import com.project.theatre_management_system.dto.Branch;
import com.project.theatre_management_system.dto.Screen;
import com.project.theatre_management_system.dto.Staff;

@Service
public class BranchService {
	@Autowired
	BranchDao branchDao;
	
	public Branch saveBranch(Branch branch) {
		return branchDao.saveBranch(branch);
	}
	
	public Branch addExistingManagerToExistingBranch(int managerId, int branchId) {	
		return branchDao.addExistingManagerToExistingBranch(managerId, branchId);
	}
	
	public Branch addExistingAddressToExistingBranch(int addressId, int branchId) {
		return branchDao.addExistingAddressToExistingBranch(addressId, branchId);
	}
	
	public Branch addExistingStaffToExistingBranch(int staffId, int branchId) {
		return branchDao.addExistingStaffToExistingBranch(staffId, branchId);
	}
	
	public Branch addNewStaffToExistingBranch(int branchId, Staff newStaff) {
		return branchDao.addNewStaffToExistingBranch(branchId, newStaff);
	}
	
	public Branch addExistingScreenToExistingBranch(int screenId, int branchId) {
		return branchDao.addExistingScreenToExistingBranch(screenId, branchId);
	}
	
	public Branch addNewScreenToExistingBranch(int branchId, Screen newScreen) {
		return branchDao.addNewScreenToExistingBranch(branchId, newScreen);
	}
	
	public Branch fetchBranchById(int branchId) {
		return branchDao.fetchBranchById(branchId);
	}
	
	public List<Branch> fetchAllBranch() {
		return branchDao.fetchAllBranch();
	}
	
	public Branch deleteBranchById(int ownerId) {
		return branchDao.deleteBranchById(ownerId);
	}
	
	public Branch updateBranchById(int oldBranchId, Branch newBranch) {
		return branchDao.updateBranchById(oldBranchId, newBranch);
	}
	
}
