package com.project.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.theatre_management_system.dao.ViewerDao;
import com.project.theatre_management_system.dto.Food;
import com.project.theatre_management_system.dto.Ticket;
import com.project.theatre_management_system.dto.Viewer;
import com.project.theatre_management_system.exception.ViewerIdNotFound;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

@Service
public class ViewerService {

	@Autowired
	ViewerDao viewerDao;

	@Autowired
	ResponseStructure<Viewer> responseStructure;

	@Autowired
	ResponseStructureList<Viewer> responseStructureList;

	public ResponseEntity<ResponseStructure<Viewer>> saveViewer(Viewer viewer) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Succesfully Saved the Viewer into db");
		responseStructure.setData(viewerDao.saveViewer(viewer));
		return new ResponseEntity<ResponseStructure<Viewer>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Viewer>> addExistingSeatToExistingViewer(int seatId, int viewerId) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Succesfully added Existing Seat To Existing Viewer in to db");
		responseStructure.setData(viewerDao.addExistingSeatToExistingViewer(seatId, viewerId));
		return new ResponseEntity<ResponseStructure<Viewer>>(responseStructure,HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Viewer>> fetchViewerById(int viewerId) {
		Viewer viewer = viewerDao.fetchViewerById(viewerId);
		if (viewer != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Succesfully fetched Viewer By Id from db");
			responseStructure.setData(viewerDao.fetchViewerById(viewerId));
			return new ResponseEntity<ResponseStructure<Viewer>>(responseStructure,HttpStatus.FOUND);
		} else {
			throw new ViewerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructureList<Viewer>> fetchAllViewer() {
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Succesfully fetched All Viewers from db");
		responseStructureList.setData(viewerDao.fetchAllViewer());
		return new ResponseEntity<ResponseStructureList<Viewer>>(responseStructureList,HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Viewer>> deleteViewerById(int ViewerId) {
		Viewer viewer = viewerDao.fetchViewerById(ViewerId);
		if (viewer != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Succesfully deleted Viewer By Id from db");
			responseStructure.setData(viewerDao.deleteViewerById(ViewerId));
			return new ResponseEntity<ResponseStructure<Viewer>>(responseStructure,HttpStatus.OK);
		} else {
			throw new ViewerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Viewer>> updateViewerById(int oldViewerId, Viewer newViewer) {
		Viewer viewer = viewerDao.fetchViewerById(oldViewerId);
		if (viewer != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Succesfully updated Viewer By Id in db");
			responseStructure.setData(viewerDao.updateViewerById(oldViewerId, newViewer));
			return new ResponseEntity<ResponseStructure<Viewer>>(responseStructure,HttpStatus.OK);
		} else {
			throw new ViewerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Viewer>> addExistingTicketToExistingViewer(int ticketId, int viewerId) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Succesfully added Existing Ticket To Existing Viewer in to db");
		responseStructure.setData(viewerDao.addExistingTicketToExistingViewer(ticketId, viewerId));
		return new ResponseEntity<ResponseStructure<Viewer>>(responseStructure,HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Viewer>> addNewTicketToExistingViewer(int viewerId, Ticket newTicket) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Succesfully added New Ticket To Existing Viewer in to db");
		responseStructure.setData(viewerDao.addNewTicketToExistingViewer(viewerId, newTicket));
		return new ResponseEntity<ResponseStructure<Viewer>>(responseStructure,HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Viewer>> addExistingFoodToExistingViewer(int foodId, int viewerId) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("successfully added Existing Food To Existing Viewer in db");
		responseStructure.setData(viewerDao.addExistingFoodToExistingViewer(foodId, viewerId));
		return new ResponseEntity<ResponseStructure<Viewer>>(responseStructure,HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Viewer>> addNewFoodToExistingViewer(int viewerId, Food newFood) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("successfully added New Food To Existing Viewer in db");
		responseStructure.setData(viewerDao.addNewFoodToExistingViewer(viewerId, newFood));
		return new ResponseEntity<ResponseStructure<Viewer>>(responseStructure,HttpStatus.FOUND);
	}
}
