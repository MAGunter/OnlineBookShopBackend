package com.kazakhi.onlinebookshop.repository;

import com.kazakhi.onlinebookshop.entity.Book;
import com.kazakhi.onlinebookshop.entity.User;
import com.kazakhi.onlinebookshop.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WishListRepository extends JpaRepository<WishList, Long> {
    List<WishList> user(User user);
    Optional<WishList> findByUserAndBook(User user, Book book);
    List<WishList> findByUser(User user);
}
