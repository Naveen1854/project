package com.project.theatre_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.theatre_management_system.dto.Movie;
import com.project.theatre_management_system.dto.Review;
import com.project.theatre_management_system.dto.Viewer;
import com.project.theatre_management_system.service.MovieService;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

@RestController
public class MovieController {

	@Autowired
	MovieService movieService;

	@PostMapping("/saveMovie")
	public ResponseStructure<Movie> saveMovie(@RequestBody Movie movie) {
		return movieService.saveMovie(movie);
	}

	@GetMapping("/fetchMovieById")
	public ResponseStructure<Movie> fetchMovieById(@RequestParam int movieId) {
		return movieService.fetchMovieById(movieId);
	}

	@GetMapping("/fetchAllMovie")
	public ResponseStructureList<Movie> fetchAllMovie() {
		return movieService.fetchAllMovie();
	}

	@DeleteMapping("/deleteMovieById")
	public ResponseStructure<Movie> deleteMovieById(@RequestParam int movieId) {
		return movieService.deleteMovieById(movieId);
	}

	@PutMapping("/updateMovieById")
	public ResponseStructure<Movie> updateMovieById(@RequestParam int oldMovieId, @RequestBody Movie newMovie) {
		return movieService.updateMovieById(oldMovieId, newMovie);
	}

	@PutMapping("/addExistingScreenToExistingMovie")
	public ResponseStructure<Movie> addExistingScreenToExistingMovie(@RequestParam int screenId,
			@RequestParam int movieId) {
		return movieService.addExistingScreenToExistingMovie(screenId, movieId);
	}

	@PutMapping("/addExistingViewerToExistingMovie")
	public ResponseStructure<Movie> addExistingViewerToExistingMovie(@RequestParam int viewerId,
			@RequestParam int movieId) {
		return movieService.addExistingViewerToExistingMovie(viewerId, movieId);
	}

	@PutMapping("/addNewViewerToExistingMovie")
	public ResponseStructure<Movie> addNewViewerToExistingMovie(@RequestParam int movieId,
			@RequestBody Viewer newViewer) {
		return movieService.addNewViewerToExistingMovie(movieId, newViewer);
	}

	@PutMapping("/addExistingReviewToExistingMovie")
	public ResponseStructure<Movie> addExistingReviewToExistingMovie(@RequestParam int reviewId,
			@RequestParam int movieId) {
		return movieService.addExistingReviewToExistingMovie(reviewId, movieId);
	}

	@PutMapping("/addNewReviewToExistingMovie")
	public ResponseStructure<Movie> addNewReviewToExistingMovie(@RequestParam int movieId,
			@RequestBody Review newReview) {
		return movieService.addNewReviewToExistingMovie(movieId, newReview);
	}
}
