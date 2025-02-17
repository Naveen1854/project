package com.project.theatre_management_system.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.theatre_management_system.dto.Address;
import com.project.theatre_management_system.dto.Branch;
import com.project.theatre_management_system.dto.Manager;
import com.project.theatre_management_system.repo.BranchRepo;

@Repository
public class BranchDao {
	@Autowired
	BranchRepo branchRepo;
	
	@Autowired
	ManagerDao managerDao;
	
	@Autowired
	AddressDao addressDao;

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

	public Branch fetchBranchById(int branchId) {
		return branchRepo.findById(branchId).get();
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
