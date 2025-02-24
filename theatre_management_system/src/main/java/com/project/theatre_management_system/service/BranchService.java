package com.project.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.theatre_management_system.dao.BranchDao;
import com.project.theatre_management_system.dto.Branch;
import com.project.theatre_management_system.dto.Screen;
import com.project.theatre_management_system.dto.Staff;
import com.project.theatre_management_system.exception.BranchIdNotFound;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

@Service
public class BranchService {
	@Autowired
	BranchDao branchDao;

	@Autowired
	ResponseStructure<Branch> responseStructure;

	@Autowired
	ResponseStructureList<Branch> responseStructureList;

	public ResponseStructure<Branch> saveBranch(Branch branch) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully saved the Branch into db");
		responseStructure.setData(branchDao.saveBranch(branch));
		return responseStructure;
	}

	public ResponseStructure<Branch> addExistingManagerToExistingBranch(int managerId, int branchId) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully added Existing Manager To Existing Branch");
		responseStructure.setData(branchDao.addExistingManagerToExistingBranch(managerId, branchId));
		return responseStructure;
	}

	public ResponseStructure<Branch> addExistingAddressToExistingBranch(int addressId, int branchId) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully added Existing Address To Existing Branch");
		responseStructure.setData(branchDao.addExistingAddressToExistingBranch(addressId, branchId));
		return responseStructure;
	}

	public ResponseStructure<Branch> addExistingStaffToExistingBranch(int staffId, int branchId) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully added Existing Staff To Existing Branch");
		responseStructure.setData(branchDao.addExistingStaffToExistingBranch(staffId, branchId));
		return responseStructure;
	}

	public ResponseStructure<Branch> addNewStaffToExistingBranch(int branchId, Staff newStaff) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully New Staff added Existing Branch");
		responseStructure.setData(branchDao.addNewStaffToExistingBranch(branchId, newStaff));
		return responseStructure;
	}

	public ResponseStructure<Branch> addExistingScreenToExistingBranch(int screenId, int branchId) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Existing screen added to Existing Branch");
		responseStructure.setData(branchDao.addExistingScreenToExistingBranch(screenId, branchId));
		return responseStructure;
	}

	public ResponseStructure<Branch> addNewScreenToExistingBranch(int branchId, Screen newScreen) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully New screen added to Existing Branch");
		responseStructure.setData(branchDao.addNewScreenToExistingBranch(branchId, newScreen));
		return responseStructure;
	}

	public ResponseStructure<Branch> fetchBranchById(int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfullyg Branch fetched By Id");
			responseStructure.setData(branchDao.fetchBranchById(branchId));
			return responseStructure;
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseStructureList<Branch> fetchAllBranch() {
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Succesfully AllBranch fetched db");
		responseStructureList.setData(branchDao.fetchAllBranch());
		return responseStructureList;
	}

	public ResponseStructure<Branch> deleteBranchById(int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Succesfully Branch deleated by id from db");
			responseStructure.setData(branchDao.deleteBranchById(branchId));
			return responseStructure;
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseStructure<Branch> updateBranchById(int oldBranchId, Branch newBranch) {
		Branch branch = branchDao.fetchBranchById(oldBranchId);
		if (branch != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Succesfully branch updated by id in db");
			responseStructure.setData(branchDao.updateBranchById(oldBranchId, newBranch));
			return responseStructure;
		} else {
			throw new BranchIdNotFound();
		}
	}
}
