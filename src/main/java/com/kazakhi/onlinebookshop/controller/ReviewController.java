package com.kazakhi.onlinebookshop.controller;

import com.kazakhi.onlinebookshop.entity.Review;
import com.kazakhi.onlinebookshop.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<String> addReview(@RequestParam Long bookId,
                                            @RequestParam Long userId,
                                            @RequestParam String comment,
                                            @RequestParam short rating) {
        reviewService.addReview(bookId, userId, comment, rating);
        return ResponseEntity.ok("Review added successfully");
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long reviewId,
                                               @RequestParam String comment,
                                               @RequestParam short rating) {
        reviewService.updateReview(reviewId, comment, rating);
        return ResponseEntity.ok("Review updated successfully");
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long reviewId) {
        reviewService.deleteReview(reviewId);
        return ResponseEntity.ok("Review deleted successfully");
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<List<Review>> getReviewsForBook(@PathVariable Long bookId, @RequestParam Long userId) {
        List<Review> reviews = Collections.singletonList(reviewService.getReviews(bookId, userId));
        return ResponseEntity.ok(reviews);
    }
}
