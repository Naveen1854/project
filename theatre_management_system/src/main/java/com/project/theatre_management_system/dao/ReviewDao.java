package com.project.theatre_management_system.dao;

import java.util.List;

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
		return reviewRepo.findById(reviewId).get();
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
