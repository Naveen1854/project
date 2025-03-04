package com.project.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.theatre_management_system.dao.OwnerDao;
import com.project.theatre_management_system.dto.Owner;
import com.project.theatre_management_system.exception.OwnerIdNotFound;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

@Service
public class OwnerService {

	@Autowired
	OwnerDao ownerDao;

	@Autowired
	ResponseStructure<Owner> responseStructure;

	@Autowired
	ResponseStructureList<Owner> responseStructureList;

	public ResponseEntity<ResponseStructure<Owner>> saveOwner(Owner owner) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Succesfully Saved the Owner into db");
		responseStructure.setData(ownerDao.saveOwner(owner));
		return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Owner>> addExistingTheatreToExistingOwner(int theatreId, int ownerId) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Theatre successfully added to the Owner");
		responseStructure.setData(ownerDao.addExistingTheatreToExistingOwner(theatreId, ownerId));
		return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Owner>> fetchOwnerById(int ownerId) {
		Owner owner = ownerDao.fetchOwnerById(ownerId);
		if (owner != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Owner successfully fetched from db");
			responseStructure.setData(ownerDao.fetchOwnerById(ownerId));
			return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new OwnerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructureList<Owner>> fetchAllOwner() {
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Succesfully all Owner fetched from db");
		responseStructureList.setData(ownerDao.fetchAllOwner());
		return new ResponseEntity<ResponseStructureList<Owner>>(responseStructureList, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Owner>> deleteOwnerById(int ownerId) {
		Owner owner = ownerDao.fetchOwnerById(ownerId);
		if (owner != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Succesfully Owner deleted by id from db");
			responseStructure.setData(ownerDao.deleteOwnerById(ownerId));
			return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.OK);
		} else {
			throw new OwnerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Owner>> updateOwnerById(int oldOwnerId, Owner newOwner) {
		Owner owner = ownerDao.fetchOwnerById(oldOwnerId);
		if (owner != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Succesfully updated Owner By Id in db");
			responseStructure.setData(ownerDao.updateOwnerById(oldOwnerId, newOwner));
			return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.OK);
		} else {
			throw new OwnerIdNotFound();
		}
	}
}
