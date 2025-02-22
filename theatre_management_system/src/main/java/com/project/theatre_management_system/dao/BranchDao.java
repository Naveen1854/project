package com.project.theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.theatre_management_system.dto.Address;
import com.project.theatre_management_system.dto.Branch;
import com.project.theatre_management_system.dto.Manager;
import com.project.theatre_management_system.dto.Screen;
import com.project.theatre_management_system.dto.Staff;
import com.project.theatre_management_system.repo.BranchRepo;

@Repository
public class BranchDao {
	@Autowired
	BranchRepo branchRepo;

	@Autowired
	ManagerDao managerDao;

	@Autowired
	AddressDao addressDao;

	@Autowired
	StaffDao staffDao;

	@Autowired
	ScreenDao screenDao;

	public Branch saveBranch(Branch branch) {
		return branchRepo.save(branch);
	}

	public Branch addExistingManagerToExistingBranch(int managerId, int branchId) {
		Manager manager = managerDao.fetchManagerById(managerId);
		Branch branch = fetchBranchById(branchId);
		branch.setManager(manager);
		return saveBranch(branch);
	}

	public Branch addExistingAddressToExistingBranch(int addressId, int branchId) {
		Address address = addressDao.fetchAddressById(addressId);
		Branch branch = fetchBranchById(branchId);
		branch.setAddress(address);
		return saveBranch(branch);
	}

	public Branch addExistingStaffToExistingBranch(int staffId, int branchId) {
		Staff staff = staffDao.fetchStaffById(staffId);
		Branch branch = fetchBranchById(branchId);
		List<Staff> list = branch.getStaff();
		list.add(staff);
		branch.setStaff(list);
		return saveBranch(branch);
	}

	public Branch addNewStaffToExistingBranch(int branchId, Staff newStaff) {
		Branch branch = fetchBranchById(branchId);
		List<Staff> list = branch.getStaff();
		list.add(newStaff);
		branch.setStaff(list);
		return saveBranch(branch);
	}

	public Branch addExistingScreenToExistingBranch(int screenId, int branchId) {
		Screen screen = screenDao.fetchScreenById(screenId);
		Branch branch = fetchBranchById(branchId);
		List<Screen> list = branch.getScreens();
		list.add(screen);
		branch.setScreens(list);
		return saveBranch(branch);
	}

	public Branch addNewScreenToExistingBranch(int branchId, Screen newScreen) {
		Branch branch = fetchBranchById(branchId);
		List<Screen> list = branch.getScreens();
		list.add(newScreen);
		branch.setScreens(list);
		return saveBranch(branch);
	}

	public Branch fetchBranchById(int branchId) {
		Optional<Branch> dbBranch = branchRepo.findById(branchId);
		if (dbBranch.isEmpty()) {
			return null;
		} else {
			return dbBranch.get();
		}
	}

	public List<Branch> fetchAllBranch() {
		return branchRepo.findAll();
	}

	public Branch deleteBranchById(int branchId) {
		Branch branch = fetchBranchById(branchId);
		branchRepo.delete(branch);
		return branch;
	}

	public Branch updateBranchById(int oldBranchId, Branch newBranch) {
		newBranch.setBranchId(oldBranchId);
		return saveBranch(newBranch);
	}
}
