package com.project.theatre_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.theatre_management_system.dto.Movie;
import com.project.theatre_management_system.service.MovieService;

@RestController
public class MovieController {
	@Autowired
	MovieService movieService;

	@PostMapping("/saveMovie")
	public Movie saveMovie(@RequestBody Movie movie) {
		return movieService.saveMovie(movie);
	}

	@GetMapping("/fetchMovieById")
	public Movie fetchMovieById(@RequestParam int movieId) {
		return movieService.fetchMovieById(movieId);
	}

	@GetMapping("/fetchAllMovie")
	public List<Movie> fetchAllMovie() {
		return movieService.fetchAllMovie();
	}

	@DeleteMapping("/deleteMovieById")
	public Movie deleteMovieById(@RequestParam int movieId) {
		return movieService.deleteMovieById(movieId);
	}

	@PutMapping("/updateMovieById")
	public Movie updateMovieById(@RequestParam int oldMovieId, @RequestBody Movie newMovie) {
		return movieService.updateMovieById(oldMovieId, newMovie);
	}
}
