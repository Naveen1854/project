package com.project.theatre_management_system.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.theatre_management_system.dto.Movie;
import com.project.theatre_management_system.dto.Screen;
import com.project.theatre_management_system.repo.MovieRepo;

@Repository
public class MovieDao {
	@Autowired
	MovieRepo movieRepo;

	@Autowired
	ScreenDao screenDao;

	public Movie saveMovie(Movie movie) {
		return movieRepo.save(movie);
	}

	public Movie addExistingScreenToExistingMovie(int screenId, int movieId) {
		Screen screen = screenDao.fetchScreenById(screenId);
		Movie movie = fetchMovieById(movieId);
		movie.setScreen(screen);
		return saveMovie(movie);
	}

	public Movie fetchMovieById(int movieId) {
		return movieRepo.findById(movieId).get();
	}

	public List<Movie> fetchAllMovie() {
		return movieRepo.findAll();
	}

	public Movie deleteMovieById(int movieId) {
		Movie movie = fetchMovieById(movieId);
		movieRepo.delete(movie);
		return movie;
	}

	public Movie updateMovieById(int oldMovieId, Movie newMovie) {
		newMovie.setMovieId(oldMovieId);
		return saveMovie(newMovie);
	}
}
