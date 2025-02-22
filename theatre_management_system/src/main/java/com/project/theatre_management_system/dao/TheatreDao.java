package com.project.theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.theatre_management_system.dto.Branch;
import com.project.theatre_management_system.dto.Theatre;
import com.project.theatre_management_system.repo.TheatreRepo;

@Repository
public class TheatreDao {

	@Autowired
	TheatreRepo theatreRepo;

	@Autowired
	BranchDao branchDao;

	public Theatre saveTheatre(Theatre theatre) {
		return theatreRepo.save(theatre);
	}

	public Theatre addExistingBranchToExistingTheatre(int branchId, int theatreId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		Theatre theatre = fetchTheatreById(theatreId);
		List<Branch> list = theatre.getBranchs();
		list.add(branch);
		theatre.setBranchs(list);
		return saveTheatre(theatre);
	}

	public Theatre addNewBranchToExistingTheatre(int theatreId, Branch newBranch) {
		Theatre theatre = fetchTheatreById(theatreId);
		List<Branch> list = theatre.getBranchs();
		list.add(newBranch);
		theatre.setBranchs(list);
		return saveTheatre(theatre);
	}

	public Theatre fetchTheatreById(int theatreId) {
		Optional<Theatre> dbTheatre = theatreRepo.findById(theatreId);
		if (dbTheatre.isEmpty())
			return null;
		return dbTheatre.get();
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
