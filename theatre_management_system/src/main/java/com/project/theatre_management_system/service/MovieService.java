package com.project.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.theatre_management_system.dao.MovieDao;
import com.project.theatre_management_system.dto.Movie;
import com.project.theatre_management_system.dto.Review;
import com.project.theatre_management_system.dto.Viewer;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

@Service
public class MovieService {
	@Autowired
	MovieDao movieDao;
	
	@Autowired
	ResponseStructure<Movie> responseStructure;
	
	@Autowired
	ResponseStructureList<Movie> responseStructureList;

	public ResponseStructure<Movie> saveMovie(Movie movie) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully saved the Movie into db");
		responseStructure.setData(movieDao.saveMovie(movie));
		return responseStructure;
	}
	
	public ResponseStructure<Movie> addExistingScreenToExistingMovie(int screenId, int movieId) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully added Existing Screen To Existing Movie");
		responseStructure.setData(movieDao.addExistingScreenToExistingMovie(screenId, movieId));
		return responseStructure;
	}
	
	public ResponseStructure<Movie> addExistingViewerToExistingMovie(int viewerId, int movieId) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully added Existing Viewer To Existing Movie");
		responseStructure.setData(movieDao.addExistingViewerToExistingMovie(viewerId, movieId));
		return responseStructure;
	}
	
	public ResponseStructure<Movie> addNewViewerToExistingMovie(int movieId, Viewer newViewer) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully added new Viewer To Existing Movie");
		responseStructure.setData(movieDao.addNewViewerToExistingMovie(movieId, newViewer));
		return responseStructure;
	}
	
	public ResponseStructure<Movie> addExistingReviewToExistingMovie(int reviewId, int movieId) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully added Existing Review To Existing Movie");
		responseStructure.setData(movieDao.addExistingReviewToExistingMovie(reviewId, movieId));
		return responseStructure;
	}
	
	public ResponseStructure<Movie> addNewReviewToExistingMovie(int movieId, Review newReview) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully added new Review To Existing Movie");
		responseStructure.setData(movieDao.addNewReviewToExistingMovie(movieId, newReview));
		return responseStructure;
	}

	public ResponseStructure<Movie> fetchMovieById(int movieId) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfullyg Movie fetched By Id");
		responseStructure.setData(movieDao.fetchMovieById(movieId));
		return responseStructure;
	}

	public ResponseStructureList<Movie> fetchAllMovie() {
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Succesfully AllMovie fetched from db");
		responseStructureList.setData(movieDao.fetchAllMovie());
		return responseStructureList;
	}

	public ResponseStructure<Movie> deleteMovieById(int movieId) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Succesfully Movie deleted by id from db");
		responseStructure.setData(movieDao.deleteMovieById(movieId));
		return responseStructure;
	}

	public ResponseStructure<Movie> updateMovieById(int oldMovieId, Movie newMovie) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Succesfully Movie updated by id in db");
		responseStructure.setData(movieDao.updateMovieById(oldMovieId, newMovie));
		return responseStructure;
	}
}
