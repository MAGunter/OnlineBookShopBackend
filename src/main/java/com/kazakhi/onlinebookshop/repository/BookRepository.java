package com.kazakhi.onlinebookshop.repository;

import com.kazakhi.onlinebookshop.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findBookByBookId(Integer bookId);
}
