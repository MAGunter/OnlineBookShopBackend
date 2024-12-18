package com.kazakhi.onlinebookshop.service.impl;

import com.kazakhi.onlinebookshop.entity.Book;
import com.kazakhi.onlinebookshop.entity.Review;
import com.kazakhi.onlinebookshop.entity.User;
import com.kazakhi.onlinebookshop.repository.BookRepository;
import com.kazakhi.onlinebookshop.repository.ReviewRepository;
import com.kazakhi.onlinebookshop.repository.UserRepository;
import com.kazakhi.onlinebookshop.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    @Override
    public void addReview(Long bookId, Long userId, String comment, short rating) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Review review = new Review();
        review.setBook(book);
        review.setUser(user);
        review.setComment(comment);
        review.setRating(rating);
        review.setCreatedAt(LocalDateTime.now());
        reviewRepository.save(review);
    }

    @Override
    public void updateReview(Long reviewId, String comment, short rating) {
        Review review = reviewRepository.findById(Math.toIntExact(reviewId))
                .orElseThrow(() -> new IllegalArgumentException("Review not found"));
        review.setComment(comment);
        review.setRating(rating);
        reviewRepository.save(review);
    }


    @Override
    public void deleteReview(Long reviewId) {
        Review review = reviewRepository.findById(Math.toIntExact(reviewId))
                .orElseThrow(() -> new IllegalArgumentException("Review not found"));
        reviewRepository.deleteByBookAndUser(review.getBook(), review.getUser());
    }

    @Override
    public Review getReviews(Long bookId, Long userId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        return reviewRepository.findByBookAndUser(book, user)
                .orElseThrow(() -> new IllegalArgumentException("Review not found"));
    }
}
