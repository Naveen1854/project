package com.project.theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.theatre_management_system.dto.Food;
import com.project.theatre_management_system.dto.Seat;
import com.project.theatre_management_system.dto.Ticket;
import com.project.theatre_management_system.dto.Viewer;
import com.project.theatre_management_system.repo.ViewerRepo;

@Repository
public class ViewerDao {

	@Autowired
	ViewerRepo viewerRepo;

	@Autowired
	SeatDao seatDao;
	
	@Autowired
	TicketDao ticketDao;
	
	@Autowired
	FoodDao foodDao;

	public Viewer saveViewer(Viewer viewer) {
		return viewerRepo.save(viewer);
	}

	public Viewer addExistingSeatToExistingViewer(int seatId, int viewerId) {
		Seat seat = seatDao.fetchSeatById(seatId);
		Viewer viewer = fetchViewerById(viewerId);
		viewer.setSeat(seat);
		return saveViewer(viewer);
	}

	public Viewer addExistingTicketToExistingViewer(int ticketId, int viewerId) {
		Ticket ticket = ticketDao.fetchTicketById(ticketId);
		Viewer viewer = fetchViewerById(viewerId);
		List<Ticket> list = viewer.getTickets();
		list.add(ticket);
		viewer.setTickets(list);
		return saveViewer(viewer);
	}
	
	public Viewer addNewTicketToExistingViewer(int viewerId, Ticket newTicket) {
		Viewer viewer = fetchViewerById(viewerId);
		List<Ticket> list = viewer.getTickets();
		list.add(newTicket);
		viewer.setTickets(list);
		return saveViewer(viewer);
	}
	
	public Viewer addExistingFoodToExistingViewer(int foodId, int viewerId) {
		Food food = foodDao.fetchFoodById(foodId);
		Viewer viewer = fetchViewerById(viewerId);
		List<Food> list = viewer.getFoods();
		list.add(food);
		viewer.setFoods(list);
		return saveViewer(viewer);
	}
	
	public Viewer addNewFoodToExistingViewer(int viewerId, Food newFood) {
		Viewer viewer = fetchViewerById(viewerId);
		List<Food> list = viewer.getFoods();
		list.add(newFood);
		viewer.setFoods(list);
		return saveViewer(viewer);
	}
	
	public Viewer fetchViewerById(int viewerId) {
		Optional<Viewer> dbViewer = viewerRepo.findById(viewerId);
		if(dbViewer.isEmpty()) return null;
		return dbViewer.get();
	}

	public List<Viewer> fetchAllViewer() {
		return viewerRepo.findAll();
	}

	public Viewer deleteViewerById(int viewerId) {
		Viewer viewer = fetchViewerById(viewerId);
		viewerRepo.delete(viewer);
		return viewer;
	}

	public Viewer updateViewerById(int oldViewerId, Viewer newViewer) {
		newViewer.setViewerId(oldViewerId);
		return saveViewer(newViewer);
	}
}
