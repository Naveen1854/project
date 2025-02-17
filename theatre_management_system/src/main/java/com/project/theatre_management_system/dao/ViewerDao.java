package com.project.theatre_management_system.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.theatre_management_system.dto.Seat;
import com.project.theatre_management_system.dto.Viewer;
import com.project.theatre_management_system.repo.ViewerRepo;

@Repository
public class ViewerDao {

	@Autowired
	ViewerRepo viewerRepo;

	@Autowired
	SeatDao seatDao;

	public Viewer saveViewer(Viewer viewer) {
		return viewerRepo.save(viewer);
	}

	public Viewer addExistingSeatToExistingViewer(int seatId, int viewerId) {
		Seat seat = seatDao.fetchSeatById(seatId);
		Viewer viewer = fetchViewerById(viewerId);
		viewer.setSeat(seat);
		return saveViewer(viewer);
	}

	public Viewer fetchViewerById(int viewerId) {
		return viewerRepo.findById(viewerId).get();
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
