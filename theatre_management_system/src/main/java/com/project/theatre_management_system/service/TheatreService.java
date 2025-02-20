package com.project.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.theatre_management_system.dao.TheatreDao;
import com.project.theatre_management_system.dto.Branch;
import com.project.theatre_management_system.dto.Theatre;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

@Service
public class TheatreService {
	
	@Autowired
	TheatreDao theatreDao;
	
	@Autowired
	ResponseStructure<Theatre> responseStructure;
	
	@Autowired
	ResponseStructureList<Theatre> responseStructureList;
	
	public ResponseStructure<Theatre> saveTheatre(Theatre theatre) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Succesfully Saved the Owner into db");
		responseStructure.setData(theatreDao.saveTheatre(theatre));
		return responseStructure;
	}
	
	public ResponseStructure<Theatre> addExistingBranchToExistingTheatre(int branchId, int theatreId) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Succesfully Saved the Owner into db");
		responseStructure.setData(theatreDao.addExistingBranchToExistingTheatre(branchId, theatreId));
		return responseStructure;
	}
	
	public ResponseStructure<Theatre> addNewBranchToExistingTheatre(int theatreId, Branch newBranch) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Succesfully Saved the Owner into db");
		responseStructure.setData(theatreDao.addNewBranchToExistingTheatre(theatreId, newBranch));
		return responseStructure;
	}
	
	public ResponseStructure<Theatre> fetchTheatreById(int theatreId) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Succesfully Saved the Owner into db");
		responseStructure.setData(theatreDao.fetchTheatreById(theatreId));
		return responseStructure;
	}
	
	public ResponseStructureList<Theatre> fetchAllTheatre() {
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Succesfully Address fetched by id from db");
		responseStructureList.setData(theatreDao.fetchAllTheatre());
		return responseStructureList;
	}
	
	public ResponseStructure<Theatre> deleteTheatreById(int theatreId) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Succesfully Address fetched by id from db");
		responseStructure.setData(theatreDao.deleteTheatreById(theatreId));
		return responseStructure;
	}
	
	public ResponseStructure<Theatre> updateTheatreById(int oldTheatreId, Theatre newTheatre) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Succesfully Address fetched by id from db");
		responseStructure.setData(theatreDao.updateTheatreById(oldTheatreId, newTheatre));
		return responseStructure;
	}
}
