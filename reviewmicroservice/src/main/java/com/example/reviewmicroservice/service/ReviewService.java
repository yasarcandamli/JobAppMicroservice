package com.example.reviewmicroservice.service;

import com.example.reviewmicroservice.entity.Review;

import java.util.List;

public interface ReviewService {
    List<Review> findAll(Long companyId);

    boolean createReview(Long companyId, Review review);

    Review getReviewById(Long id);

    boolean deleteReviewById(Long id);

    boolean updateReview(Long id, Review updatedReview);
}
