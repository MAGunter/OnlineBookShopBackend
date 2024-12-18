package com.kazakhi.onlinebookshop.repository;

import com.kazakhi.onlinebookshop.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findBookByBookId(Integer bookId);
}
