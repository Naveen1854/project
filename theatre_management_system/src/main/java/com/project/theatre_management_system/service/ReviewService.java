package com.project.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	public ResponseEntity<ResponseStructure<Review>> saveReview(Review review) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Succesfully Saved the Review into db");
		responseStructure.setData(reviewDao.saveReview(review));
		return new ResponseEntity<ResponseStructure<Review>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Review>> fetchReviewById(int reviewId) {
		Review review = reviewDao.fetchReviewById(reviewId);
		if (review != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Succesfully fetched the Review from db");
			responseStructure.setData(reviewDao.fetchReviewById(reviewId));
			return new ResponseEntity<ResponseStructure<Review>>(responseStructure,HttpStatus.FOUND);
		} else {
			throw new ReviewIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructureList<Review>> fetchAllReview() {
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Succesfully fetched All Reviews from db");
		responseStructureList.setData(reviewDao.fetchAllReview());
		return new ResponseEntity<ResponseStructureList<Review>>(responseStructureList,HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Review>> deleteReviewById(int reviewId) {
		Review review = reviewDao.fetchReviewById(reviewId);
		if (review != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Succesfully deleted review by id from db");
			responseStructure.setData(reviewDao.deleteReviewById(reviewId));
			return new ResponseEntity<ResponseStructure<Review>>(responseStructure,HttpStatus.OK);
		} else {
			throw new ReviewIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Review>> updateReviewById(int oldReviewId, Review newReview) {
		Review review = reviewDao.fetchReviewById(oldReviewId);
		if (review != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Succesfully updated reveiew by id in db");
			responseStructure.setData(reviewDao.updateReviewById(oldReviewId, newReview));
			return new ResponseEntity<ResponseStructure<Review>>(responseStructure,HttpStatus.OK);
		} else {
			throw new ReviewIdNotFound();
		}
	}
}
