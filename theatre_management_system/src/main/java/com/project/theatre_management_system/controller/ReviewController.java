package com.project.theatre_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.theatre_management_system.dto.Review;
import com.project.theatre_management_system.service.ReviewService;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class ReviewController {
	@Autowired
	ReviewService reviewService;

	@Operation(summary = "Save Review", description = "API is used to save the Review")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created") })
	@PostMapping("/saveReview")
	public ResponseEntity<ResponseStructure<Review>> saveReview(@RequestBody Review review) {
		return reviewService.saveReview(review);
	}

	@Operation(summary = "fetch Review", description = "API is used to fetch the Review")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully fetched"),
			@ApiResponse(responseCode = "404", description = "Review not found for the given id") })
	@GetMapping("/fetchReviewById")
	public ResponseEntity<ResponseStructure<Review>> fetchReviewById(@RequestParam int reviewId) {
		return reviewService.fetchReviewById(reviewId);
	}

	@Operation(summary = "fetch all Review", description = "API is used to fetch all the Reviews")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully fetched") })
	@GetMapping("/fetchAllReview")
	public ResponseEntity<ResponseStructureList<Review>> fetchAllReview() {
		return reviewService.fetchAllReview();
	}

	@Operation(summary = "delete Review", description = "API is used to delete the Review")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully deleted"),
			@ApiResponse(responseCode = "404", description = "Review not found for the given id") })
	@DeleteMapping("/deleteReviewById")
	public ResponseEntity<ResponseStructure<Review>> deleteReviewById(@RequestParam int reviewId) {
		return reviewService.deleteReviewById(reviewId);
	}

	@Operation(summary = "update Review", description = "API is used to update the Review")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully updated"),
			@ApiResponse(responseCode = "404", description = "Review not found for the given id") })
	@PutMapping("/updateReviewById")
	public ResponseEntity<ResponseStructure<Review>> updateReviewById(@RequestParam int oldReviewId,
			@RequestBody Review newReview) {
		return reviewService.updateReviewById(oldReviewId, newReview);
	}
}
