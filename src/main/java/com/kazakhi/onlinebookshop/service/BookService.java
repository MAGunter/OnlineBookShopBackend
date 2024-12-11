package com.kazakhi.onlinebookshop.service;

import com.kazakhi.onlinebookshop.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(Integer bookId);
    byte[] getBookImage(Integer bookId);
}
