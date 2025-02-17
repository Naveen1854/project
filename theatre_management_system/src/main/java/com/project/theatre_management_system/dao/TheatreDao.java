package com.project.theatre_management_system.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.theatre_management_system.dto.Theatre;
import com.project.theatre_management_system.repo.TheatreRepo;

@Repository
public class TheatreDao {
	
	@Autowired
	TheatreRepo theatreRepo;
	
	public Theatre saveTheatre(Theatre theatre) {
		return theatreRepo.save(theatre);
	}
	
	public Theatre fetchTheatreById(int theatreId) {
		return theatreRepo.findById(theatreId).get();
	}
	
	public List<Theatre> fetchAllTheatre() {
		return theatreRepo.findAll();
	}
	
	public Theatre deleteTheatreById(int theatreId) {
		Theatre Theatre = fetchTheatreById(theatreId);
		theatreRepo.delete(Theatre);
		return Theatre;
	}
	
	public Theatre updateTheatreById(int oldTheatreId, Theatre newTheatre) {
		newTheatre.setTheatreId(oldTheatreId);
		return saveTheatre(newTheatre);
	}
}
