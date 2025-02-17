package com.project.theatre_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.theatre_management_system.dao.TheatreDao;
import com.project.theatre_management_system.dto.Theatre;

@Service
public class TheatreService {
	
	@Autowired
	TheatreDao theatreDao;
	
	public Theatre saveTheatre(Theatre theatre) {
		return theatreDao.saveTheatre(theatre);
	}
	
	public Theatre fetchTheatreById(int theatreId) {
		return theatreDao.fetchTheatreById(theatreId);
	}
	
	public List<Theatre> fetchAllTheatre() {
		return theatreDao.fetchAllTheatre();
	}
	
	public Theatre deleteTheatreById(int theatreId) {
		return theatreDao.deleteTheatreById(theatreId);
	}
	
	public Theatre updateTheatreById(int oldTheatreId, Theatre newTheatre) {
		return theatreDao.updateTheatreById(oldTheatreId, newTheatre);
	}
}
