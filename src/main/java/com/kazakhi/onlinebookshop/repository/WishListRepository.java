package com.kazakhi.onlinebookshop.repository;

import com.kazakhi.onlinebookshop.entity.Book;
import com.kazakhi.onlinebookshop.entity.Users;
import com.kazakhi.onlinebookshop.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WishListRepository extends JpaRepository<WishList, Long> {
    List<WishList> user(Users user);
    Optional<WishList> findByUserAndBook(Users user, Book book);
    List<WishList> findByUser(Users user);
}
