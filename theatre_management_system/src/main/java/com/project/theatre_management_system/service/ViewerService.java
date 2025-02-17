package com.project.theatre_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.theatre_management_system.dao.ViewerDao;
import com.project.theatre_management_system.dto.Viewer;

@Service
public class ViewerService {

	@Autowired
	ViewerDao viewerDao;
	
	public Viewer saveViewer(Viewer viewer) {
		return viewerDao.saveViewer(viewer);
	}
	
	public Viewer addExistingSeatToExistingViewer(int seatId, int viewerId) {
		return viewerDao.addExistingSeatToExistingViewer(seatId, viewerId);
	}
	
	public Viewer fetchViewerById(int viewerId) {
		return viewerDao.fetchViewerById(viewerId);
	}
	
	public List<Viewer> fetchAllViewer() {
		return viewerDao.fetchAllViewer();
	}
	
	public Viewer deleteViewerById(int ViewerId) {
		return viewerDao.deleteViewerById(ViewerId);
	}
	
	public Viewer updateViewerById(int oldViewerId, Viewer newViewer) {
		return viewerDao.updateViewerById(oldViewerId, newViewer);
	}
}
