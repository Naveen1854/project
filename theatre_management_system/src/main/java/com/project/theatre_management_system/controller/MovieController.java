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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class MovieController {

	@Autowired
	MovieService movieService;

	@Operation(summary = "Save Movie", description = "API is used to save the Movie")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created") })
	@PostMapping("/saveMovie")
	public ResponseStructure<Movie> saveMovie(@RequestBody Movie movie) {
		return movieService.saveMovie(movie);
	}

	@Operation(summary = "fetch Movie", description = "API is used to fetch the Movie")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully saved"),
			@ApiResponse(responseCode = "404", description = "Movie not found for the given id") })
	@GetMapping("/fetchMovieById")
	public ResponseStructure<Movie> fetchMovieById(@RequestParam int movieId) {
		return movieService.fetchMovieById(movieId);
	}

	@Operation(summary = "fetch all Movie", description = "API is used to fetch all the Movies")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully fetched") })
	@GetMapping("/fetchAllMovie")
	public ResponseStructureList<Movie> fetchAllMovie() {
		return movieService.fetchAllMovie();
	}

	@Operation(summary = "delete Movie", description = "API is used to delete the Movie")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully deleted"),
			@ApiResponse(responseCode = "404", description = "Movie not found for the given id") })
	@DeleteMapping("/deleteMovieById")
	public ResponseStructure<Movie> deleteMovieById(@RequestParam int movieId) {
		return movieService.deleteMovieById(movieId);
	}

	@Operation(summary = "update Movie", description = "API is used to update the Movie")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully updated"),
			@ApiResponse(responseCode = "404", description = "Movie not found for the given id") })
	@PutMapping("/updateMovieById")
	public ResponseStructure<Movie> updateMovieById(@RequestParam int oldMovieId, @RequestBody Movie newMovie) {
		return movieService.updateMovieById(oldMovieId, newMovie);
	}

	@Operation(summary = "Add Existing Screen To Existing Movie", description = "API is used to addExistingScreenToExistingMovie")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Successfully addExistingScreenToExistingMovie"),
			@ApiResponse(responseCode = "404", description = "Screen/Movie not found for the given id") })
	@PutMapping("/addExistingScreenToExistingMovie")
	public ResponseStructure<Movie> addExistingScreenToExistingMovie(@RequestParam int screenId,
			@RequestParam int movieId) {
		return movieService.addExistingScreenToExistingMovie(screenId, movieId);
	}

	@Operation(summary = "Add Existing Viewer To Existing Movie", description = "API is used to addExistingViewerToExistingMovie")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Successfully addExistingViewerToExistingMovie"),
			@ApiResponse(responseCode = "404", description = "Screen/Movie not found for the given id") })
	@PutMapping("/addExistingViewerToExistingMovie")
	public ResponseStructure<Movie> addExistingViewerToExistingMovie(@RequestParam int viewerId,
			@RequestParam int movieId) {
		return movieService.addExistingViewerToExistingMovie(viewerId, movieId);
	}

	@Operation(summary = "Add New Viewer To Existing Movie", description = "API is used to addNewViewerToExistingMovie")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Successfully addNewViewerToExistingMovie"),
			@ApiResponse(responseCode = "404", description = "Movie/newViewer not found for the given id") })
	@PutMapping("/addNewViewerToExistingMovie")
	public ResponseStructure<Movie> addNewViewerToExistingMovie(@RequestParam int movieId,
			@RequestBody Viewer newViewer) {
		return movieService.addNewViewerToExistingMovie(movieId, newViewer);
	}

	@Operation(summary = "Add Existing Review To Existing Movie", description = "API is used to addExistingReviewToExistingMovie")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Successfully addExistingReviewToExistingMovie"),
			@ApiResponse(responseCode = "404", description = "Viewer/Movie not found for the given id") })
	@PutMapping("/addExistingReviewToExistingMovie")
	public ResponseStructure<Movie> addExistingReviewToExistingMovie(@RequestParam int reviewId,
			@RequestParam int movieId) {
		return movieService.addExistingReviewToExistingMovie(reviewId, movieId);
	}

	@Operation(summary = "Add New Review To Existing Movie", description = "API is used to addNewReviewToExistingMovie")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Successfully addNewReviewToExistingMovie"),
			@ApiResponse(responseCode = "404", description = "Movie/newReview not found for the given id") })
	@PutMapping("/addNewReviewToExistingMovie")
	public ResponseStructure<Movie> addNewReviewToExistingMovie(@RequestParam int movieId,
			@RequestBody Review newReview) {
		return movieService.addNewReviewToExistingMovie(movieId, newReview);
	}
}
