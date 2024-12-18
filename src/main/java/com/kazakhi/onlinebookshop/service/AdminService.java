package com.kazakhi.onlinebookshop.service;

import com.kazakhi.onlinebookshop.dto.BookDTO;
import com.kazakhi.onlinebookshop.dto.CategoryDTO;
import com.kazakhi.onlinebookshop.dto.OrderDTO;
import com.kazakhi.onlinebookshop.dto.StatisticsResponse;

import java.util.List;

public interface AdminService {
    StatisticsResponse getStatistics();
    List<BookDTO> getAllBooks();
    BookDTO addBook(BookDTO bookDTO);
    BookDTO updateBook(Integer bookId, BookDTO bookDTO);
    void deleteBook(Integer bookId);
    String updateBookImage(Long bookId, String imageUrl);
    CategoryDTO addCategory(CategoryDTO categoryDTO);
    CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO);
    void deleteCategory(Long id);
    OrderDTO updateOrderStatus(Long orderId, String status);
    void deleteOrder(Long orderId);
}
