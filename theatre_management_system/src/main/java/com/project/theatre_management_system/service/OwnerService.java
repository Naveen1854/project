package com.project.theatre_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.theatre_management_system.dao.OwnerDao;
import com.project.theatre_management_system.dto.Owner;

@Service
public class OwnerService {
	
	@Autowired
	OwnerDao ownerDao;
	
	public Owner saveOwner(Owner owner) {
		return ownerDao.saveOwner(owner);
	}
	
	public Owner fetchOwnweById(int ownerId) {
		return ownerDao.fetchOwnweById(ownerId);
	}
	
	public List<Owner> fetchAllOwner() {
		return ownerDao.fetchAllOwner();
	}
	
	public Owner deleteOwnerById(int ownerId) {
		return ownerDao.deleteOwnerById(ownerId);
	}
	
	public Owner updateOwnerById(int oldOwnerId, Owner newOwner) {
		return ownerDao.updateOwnerById(oldOwnerId, newOwner);
	}
}
