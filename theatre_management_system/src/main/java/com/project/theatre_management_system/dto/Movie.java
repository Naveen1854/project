package com.project.theatre_management_system.dto;

import java.sql.Time;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int movieId;
	private String movieName;
	private String movieType;
	private Time movieDuration;
	private String movieLanguage;
	private double movieBudget;

	@OneToOne(cascade = CascadeType.ALL)
	private Screen screen;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Viewer> viewers;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Review> reviews;
	
	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieType() {
		return movieType;
	}

	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}

	public Time getMovieDuration() {
		return movieDuration;
	}

	public void setMovieDuration(Time movieDuration) {
		this.movieDuration = movieDuration;
	}

	public String getMovieLanguage() {
		return movieLanguage;
	}

	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}

	public double getMovieBudget() {
		return movieBudget;
	}

	public void setMovieBudget(double movieBudget) {
		this.movieBudget = movieBudget;
	}

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public List<Viewer> getViewers() {
		return viewers;
	}

	public void setViewers(List<Viewer> viewers) {
		this.viewers = viewers;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

}
