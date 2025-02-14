package com.example.reviewmicroservice.controller;

import com.example.reviewmicroservice.entity.Review;
import com.example.reviewmicroservice.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity<List<Review>> findAll(@RequestParam Long companyId) {
        return new ResponseEntity<>(reviewService.findAll(companyId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createReview(@RequestParam Long companyId,
                                               @RequestBody Review review) {
        boolean isReviewSaved = reviewService.createReview(companyId, review);
        if (isReviewSaved) {
            return new ResponseEntity<>("Review added successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Review not saved", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
        return new ResponseEntity<>(reviewService.getReviewById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable Long id) {
        boolean isDeleted = reviewService.deleteReviewById(id);
        if (isDeleted) {
            return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Review not found", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateReview(@PathVariable Long id,
                                               @RequestBody Review updatedReview) {
        boolean isUpdated = reviewService.updateReview(id, updatedReview);
        if (isUpdated) {
            return new ResponseEntity<>("Review updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Review not found", HttpStatus.NOT_FOUND);
        }
    }
}
