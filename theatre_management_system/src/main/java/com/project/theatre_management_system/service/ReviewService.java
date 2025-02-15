package com.project.theatre_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.theatre_management_system.dao.ReviewDao;
import com.project.theatre_management_system.dto.Review;

@Service
public class ReviewService {
	@Autowired
	ReviewDao reviewDao;

	public Review saveReview(Review review) {
		return reviewDao.saveReview(review);
	}

	public Review fetchReviewById(int reviewId) {
		return reviewDao.fetchReviewById(reviewId);
	}

	public List<Review> fetchAllReview() {
		return reviewDao.fetchAllReview();
	}

	public Review deleteReviewById(int reviewId) {
		return reviewDao.deleteRwviewById(reviewId);
	}

	public Review updateReviewById(int oldReviewId, Review newReview) {
		return reviewDao.updateReviewById(oldReviewId, newReview);
	}
}
