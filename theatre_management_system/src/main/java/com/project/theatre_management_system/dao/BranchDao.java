package com.project.theatre_management_system.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.theatre_management_system.dto.Branch;
import com.project.theatre_management_system.repo.BranchRepo;

@Repository
public class BranchDao {
	@Autowired
	BranchRepo branchRepo;
	
	public Branch saveBranch(Branch branch) {
		return branchRepo.save(branch);
	}
	
	public Branch fetchBranchById(int branchId) {
		return branchRepo.findById(branchId).get();
	}
	
	public List<Branch> fetchAllBranch() {
		return branchRepo.findAll();
	}
	
	public Branch deleteOwnerById(int branchId) {
		Branch branch = fetchBranchById(branchId);
		branchRepo.delete(branch);
		return branch;
	}
	
	public Branch updateBranchById(int oldBranchId, Branch newBranch) {
		newBranch.setBranchId(oldBranchId);
		return saveBranch(newBranch);
	}
}
