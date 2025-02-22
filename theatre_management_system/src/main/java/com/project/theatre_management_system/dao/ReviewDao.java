package com.project.theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.theatre_management_system.dto.Review;
import com.project.theatre_management_system.repo.ReviewRepo;

@Repository
public class ReviewDao {
	@Autowired
	ReviewRepo reviewRepo;

	public Review saveReview(Review review) {
		return reviewRepo.save(review);
	}

	public Review fetchReviewById(int reviewId) {
		Optional<Review> dbReview = reviewRepo.findById(reviewId);
		if (dbReview.isEmpty())
			return null;
		return dbReview.get();
	}

	public List<Review> fetchAllReview() {
		return reviewRepo.findAll();
	}

	public Review deleteRwviewById(int reviewId) {
		Review review = fetchReviewById(reviewId);
		reviewRepo.delete(review);
		return review;
	}

	public Review updateReviewById(int oldReviewId, Review newReview) {
		newReview.setReviewId(oldReviewId);
		return saveReview(newReview);
	}
}
