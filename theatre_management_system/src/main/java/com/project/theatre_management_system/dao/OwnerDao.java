package com.project.theatre_management_system.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.theatre_management_system.dto.Owner;
import com.project.theatre_management_system.repo.OwnerRepo;

@Repository
public class OwnerDao {
	@Autowired
	OwnerRepo ownerRepo;
	
	public Owner saveOwner(Owner owner) {
		return ownerRepo.save(owner);
	}
	
	public Owner fetchOwnweById(int ownerId) {
		return ownerRepo.findById(ownerId).get();
	}
	
	public List<Owner> fetchAllOwner() {
		return ownerRepo.findAll();
	}
	
	public Owner deleteOwnerById(int ownerId) {
		Owner owner = fetchOwnweById(ownerId);
		ownerRepo.delete(owner);
		return owner;
	}
	
	public Owner updateOwnerById(int oldOwnerId, Owner newOwner) {
		newOwner.setOwnerId(oldOwnerId);
		return saveOwner(newOwner);
	}
}
