package com.project.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.theatre_management_system.dao.ReviewDao;
import com.project.theatre_management_system.dto.Review;
import com.project.theatre_management_system.exception.ReviewIdNotFound;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

@Service
public class ReviewService {
	@Autowired
	ReviewDao reviewDao;

	@Autowired
	ResponseStructure<Review> responseStructure;

	@Autowired
	ResponseStructureList<Review> responseStructureList;

	public ResponseStructure<Review> saveReview(Review review) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Succesfully Saved the Owner into db");
		responseStructure.setData(reviewDao.saveReview(review));
		return responseStructure;
	}

	public ResponseStructure<Review> fetchReviewById(int reviewId) {
		Review review = reviewDao.fetchReviewById(reviewId);
		if (review != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Succesfully Saved the Owner into db");
			responseStructure.setData(reviewDao.fetchReviewById(reviewId));
			return responseStructure;
		} else {
			throw new ReviewIdNotFound();
		}
	}

	public ResponseStructureList<Review> fetchAllReview() {
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Succesfully Address fetched by id from db");
		responseStructureList.setData(reviewDao.fetchAllReview());
		return responseStructureList;
	}

	public ResponseStructure<Review> deleteReviewById(int reviewId) {
		Review review = reviewDao.fetchReviewById(reviewId);
		if (review != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Succesfully Address fetched by id from db");
			responseStructure.setData(reviewDao.deleteRwviewById(reviewId));
			return responseStructure;
		} else {
			throw new ReviewIdNotFound();
		}
	}

	public ResponseStructure<Review> updateReviewById(int oldReviewId, Review newReview) {
		Review review = reviewDao.fetchReviewById(oldReviewId);
		if (review != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Succesfully Address fetched by id from db");
			responseStructure.setData(reviewDao.updateReviewById(oldReviewId, newReview));
			return responseStructure;
		} else {
			throw new ReviewIdNotFound();
		}
	}
}
