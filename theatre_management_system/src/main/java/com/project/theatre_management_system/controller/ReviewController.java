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

import com.project.theatre_management_system.dto.Review;
import com.project.theatre_management_system.service.ReviewService;

@RestController
public class ReviewController {
	@Autowired
	ReviewService reviewService;
	
	@PostMapping("/saveReview")
	public Review saveReview(@RequestBody Review review) {
		return reviewService.saveReview(review);
	}
	
	@GetMapping("/fetchReviewById")
	public Review fetchReviewById(@RequestParam int reviewId) {
		return reviewService.fetchReviewById(reviewId);
	}
	
	@GetMapping("/fetchAllReview")
	public List<Review> fetchAllReview() {
		return reviewService.fetchAllReview();
	}
	
	@DeleteMapping("/deleteReviewById")
	public Review deleteReviewById(@RequestParam int reviewId) {
		return reviewService.deleteReviewById(reviewId);
	}
	
	@PutMapping("/updateReviewById")
	public Review updateReviewById(@RequestParam int oldReviewId, @RequestBody Review newReview) {
		return reviewService.updateReviewById(oldReviewId, newReview);
	}
}


