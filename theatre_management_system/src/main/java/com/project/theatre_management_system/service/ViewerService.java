package com.project.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

	public ResponseStructure<Viewer> saveViewer(Viewer viewer) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Succesfully Saved the Owner into db");
		responseStructure.setData(viewerDao.saveViewer(viewer));
		return responseStructure;
	}

	public ResponseStructure<Viewer> addExistingSeatToExistingViewer(int seatId, int viewerId) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Succesfully Saved the Owner into db");
		responseStructure.setData(viewerDao.addExistingSeatToExistingViewer(seatId, viewerId));
		return responseStructure;
	}

	public ResponseStructure<Viewer> fetchViewerById(int viewerId) {
		Viewer viewer = viewerDao.fetchViewerById(viewerId);
		if (viewer != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Succesfully Saved the Owner into db");
			responseStructure.setData(viewerDao.fetchViewerById(viewerId));
			return responseStructure;
		} else {
			throw new ViewerIdNotFound();
		}
	}

	public ResponseStructureList<Viewer> fetchAllViewer() {
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Succesfully Address fetched by id from db");
		responseStructureList.setData(viewerDao.fetchAllViewer());
		return responseStructureList;
	}

	public ResponseStructure<Viewer> deleteViewerById(int ViewerId) {
		Viewer viewer = viewerDao.fetchViewerById(ViewerId);
		if (viewer != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Succesfully Address fetched by id from db");
			responseStructure.setData(viewerDao.deleteViewerById(ViewerId));
			return responseStructure;
		} else {
			throw new ViewerIdNotFound();
		}
	}

	public ResponseStructure<Viewer> updateViewerById(int oldViewerId, Viewer newViewer) {
		Viewer viewer = viewerDao.fetchViewerById(oldViewerId);
		if (viewer != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Succesfully Address fetched by id from db");
			responseStructure.setData(viewerDao.updateViewerById(oldViewerId, newViewer));
			return responseStructure;
		} else {
			throw new ViewerIdNotFound();
		}
	}

	public ResponseStructure<Viewer> addExistingTicketToExistingViewer(int ticketId, int viewerId) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Theatre successfully added to the Owner");
		responseStructure.setData(viewerDao.addExistingTicketToExistingViewer(ticketId, viewerId));
		return responseStructure;
	}

	public ResponseStructure<Viewer> addNewTicketToExistingViewer(int viewerId, Ticket newTicket) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Theatre successfully added to the Owner");
		responseStructure.setData(viewerDao.addNewTicketToExistingViewer(viewerId, newTicket));
		return responseStructure;
	}

	public ResponseStructure<Viewer> addExistingFoodToExistingViewer(int foodId, int viewerId) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Theatre successfully added to the Owner");
		responseStructure.setData(viewerDao.addExistingFoodToExistingViewer(foodId, viewerId));
		return responseStructure;
	}

	public ResponseStructure<Viewer> addNewFoodToExistingViewer(int viewerId, Food newFood) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Theatre successfully added to the Owner");
		responseStructure.setData(viewerDao.addNewFoodToExistingViewer(viewerId, newFood));
		return responseStructure;
	}
}
