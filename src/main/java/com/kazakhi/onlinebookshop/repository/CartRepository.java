package com.kazakhi.onlinebookshop.repository;

import com.kazakhi.onlinebookshop.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByUser_UserId(Integer userId);
    Optional<Cart> findByUser_UserIdAndBook_BookId(Integer userId, Long bookId);
    void deleteByUser_UserIdAndBook_BookId(Integer userId, Long bookId);
}
