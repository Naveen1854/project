package com.project.theatre_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.theatre_management_system.dao.MovieDao;
import com.project.theatre_management_system.dto.Movie;

@Service
public class MovieService {
	@Autowired
	MovieDao movieDao;

	public Movie saveMovie(Movie movie) {
		return movieDao.saveMovie(movie);
	}

	public Movie fetchMovieById(int movieId) {
		return movieDao.fetchMovieById(movieId);
	}

	public List<Movie> fetchAllMovie() {
		return movieDao.fetchAllMovie();
	}

	public Movie deleteMovieById(int movieId) {
		return movieDao.deleteMovieById(movieId);
	}

	public Movie updateMovieById(int oldMovieId, Movie newMovie) {
		return movieDao.updateMovieById(oldMovieId, newMovie);
	}
}
