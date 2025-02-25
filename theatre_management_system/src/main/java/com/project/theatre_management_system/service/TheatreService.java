package com.project.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.theatre_management_system.dao.TheatreDao;
import com.project.theatre_management_system.dto.Branch;
import com.project.theatre_management_system.dto.Theatre;
import com.project.theatre_management_system.exception.TheatreIdNotFound;
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

	public ResponseEntity<ResponseStructure<Theatre>> saveTheatre(Theatre theatre) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Succesfully Saved the Theatre into db");
		responseStructure.setData(theatreDao.saveTheatre(theatre));
		return new ResponseEntity<ResponseStructure<Theatre>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Theatre>> addExistingBranchToExistingTheatre(int branchId, int theatreId) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Succesfully added Existing Branch To Existing Theatre in to db");
		responseStructure.setData(theatreDao.addExistingBranchToExistingTheatre(branchId, theatreId));
		return new ResponseEntity<ResponseStructure<Theatre>>(responseStructure,HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Theatre>> addNewBranchToExistingTheatre(int theatreId, Branch newBranch) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Succesfully added New Branch To Existing Theatre in to db");
		responseStructure.setData(theatreDao.addNewBranchToExistingTheatre(theatreId, newBranch));
		return new ResponseEntity<ResponseStructure<Theatre>>(responseStructure,HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Theatre>> fetchTheatreById(int theatreId) {
		Theatre theatre = theatreDao.fetchTheatreById(theatreId);
		if (theatre != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Succesfully fetched Theatre By Id from db");
			responseStructure.setData(theatreDao.fetchTheatreById(theatreId));
			return new ResponseEntity<ResponseStructure<Theatre>>(responseStructure,HttpStatus.FOUND);
		} else {
			throw new TheatreIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructureList<Theatre>> fetchAllTheatre() {
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Succesfully fetched All Theatre from db");
		responseStructureList.setData(theatreDao.fetchAllTheatre());
		return new ResponseEntity<ResponseStructureList<Theatre>>(responseStructureList,HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Theatre>> deleteTheatreById(int theatreId) {
		Theatre theatre = theatreDao.fetchTheatreById(theatreId);
		if (theatre != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Succesfully deleted Theatre By Id from db");
			responseStructure.setData(theatreDao.deleteTheatreById(theatreId));
			return new ResponseEntity<ResponseStructure<Theatre>>(responseStructure,HttpStatus.OK);
		} else {
			throw new TheatreIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Theatre>> updateTheatreById(int oldTheatreId, Theatre newTheatre) {
		Theatre theatre = theatreDao.fetchTheatreById(oldTheatreId);
		if (theatre != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Succesfully updated Theatre By Id from db");
			responseStructure.setData(theatreDao.updateTheatreById(oldTheatreId, newTheatre));
			return new ResponseEntity<ResponseStructure<Theatre>>(responseStructure,HttpStatus.OK);
		} else {
			throw new TheatreIdNotFound();
		}
	}
}
