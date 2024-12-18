package com.kazakhi.onlinebookshop.service;

import com.kazakhi.onlinebookshop.entity.Review;
import org.springframework.stereotype.Service;

@Service
public interface ReviewService {
    void addReview(Long bookId, Long userId, String comment, short rating);
    void updateReview(Long reviewId, String comment, short rating);
    void deleteReview(Long reviewId);
    Review getReviews(Long bookId, Long userId);
}
