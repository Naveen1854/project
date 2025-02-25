package com.project.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully saved the Branch into db");
		responseStructure.setData(branchDao.saveBranch(branch));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Branch>> addExistingManagerToExistingBranch(int managerId, int branchId) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully added Existing Manager To Existing Branch");
		responseStructure.setData(branchDao.addExistingManagerToExistingBranch(managerId, branchId));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Branch>> addExistingAddressToExistingBranch(int addressId, int branchId) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully added Existing Address To Existing Branch");
		responseStructure.setData(branchDao.addExistingAddressToExistingBranch(addressId, branchId));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Branch>> addExistingStaffToExistingBranch(int staffId, int branchId) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully added Existing Staff To Existing Branch");
		responseStructure.setData(branchDao.addExistingStaffToExistingBranch(staffId, branchId));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Branch>> addNewStaffToExistingBranch(int branchId, Staff newStaff) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully New Staff added Existing Branch");
		responseStructure.setData(branchDao.addNewStaffToExistingBranch(branchId, newStaff));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Branch>> addExistingScreenToExistingBranch(int screenId, int branchId) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Existing screen added to Existing Branch");
		responseStructure.setData(branchDao.addExistingScreenToExistingBranch(screenId, branchId));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Branch>> addNewScreenToExistingBranch(int branchId, Screen newScreen) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully New screen added to Existing Branch");
		responseStructure.setData(branchDao.addNewScreenToExistingBranch(branchId, newScreen));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Branch>> fetchBranchById(int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfullyg Branch fetched By Id from db");
			responseStructure.setData(branchDao.fetchBranchById(branchId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructureList<Branch>> fetchAllBranch() {
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Succesfully All Branches fetched from db");
		responseStructureList.setData(branchDao.fetchAllBranch());
		return new ResponseEntity<ResponseStructureList<Branch>>(responseStructureList, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Branch>> deleteBranchById(int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Succesfully Branch deleated by id from db");
			responseStructure.setData(branchDao.deleteBranchById(branchId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> updateBranchById(int oldBranchId, Branch newBranch) {
		Branch branch = branchDao.fetchBranchById(oldBranchId);
		if (branch != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Succesfully branch updated by id in db");
			responseStructure.setData(branchDao.updateBranchById(oldBranchId, newBranch));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BranchIdNotFound();
		}
	}
}
