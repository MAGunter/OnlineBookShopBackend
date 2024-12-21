package com.kazakhi.onlinebookshop.service.impl;

import com.kazakhi.onlinebookshop.dto.BookDTO;
import com.kazakhi.onlinebookshop.dto.CategoryDTO;
import com.kazakhi.onlinebookshop.dto.OrderDTO;
import com.kazakhi.onlinebookshop.dto.StatisticsResponse;
import com.kazakhi.onlinebookshop.entity.*;
import com.kazakhi.onlinebookshop.repository.AuthorRepository;
import com.kazakhi.onlinebookshop.repository.BookRepository;
import com.kazakhi.onlinebookshop.repository.CategoryRepository;
import com.kazakhi.onlinebookshop.repository.OrderRepository;
import com.kazakhi.onlinebookshop.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;
    private final OrderRepository orderRepository;
    private final AuthorRepository authorRepository;

    @Override
    public StatisticsResponse getStatistics() {
        long totalBooks = bookRepository.count();
        long totalOrders = orderRepository.count();
        return new StatisticsResponse(totalBooks, totalOrders);
    }

    @Override
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(book -> new BookDTO(book.getBookId(), book.getTitle(), book.getAuthor().getId(),
                        book.getCategory().getCategoryId(), book.getPrice(), book.getDiscount(),
                        book.getStockQuantity(), book.getDescription(), book.getPublishedYear(), null))
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO addBook(BookDTO bookDTO) {
        Author author = authorRepository.findById(bookDTO.authorId())
                .orElseThrow(() -> new IllegalArgumentException("Author not found"));

        Category category = categoryRepository.findById(Long.valueOf(bookDTO.categoryId()))
                .orElse(null);

        Book book = new Book();
        book.setTitle(bookDTO.title());
        book.setDescription(bookDTO.description());
        book.setPrice(bookDTO.price());
        book.setAuthor(author); // Устанавливаем автора
        book.setCategory(category); // Устанавливаем категорию, если она есть

        Book savedBook = bookRepository.save(book);
        return convertToDTO(savedBook);
    }

    @Override
    public BookDTO updateBook(Integer bookId, BookDTO bookDTO) {
        Book book = bookRepository.findById(Long.valueOf(bookId))
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + bookId));

        book.setTitle(bookDTO.title());
        book.setPrice(bookDTO.price());
        book.setDiscount(bookDTO.discount());
        book.setStockQuantity(bookDTO.stockQuantity());
        book.setDescription(bookDTO.description());
        book.setPublishedYear(bookDTO.publishedYear());
        book.setUpdatedAt(java.time.LocalDateTime.now());

        book = bookRepository.save(book);
        return convertToDTO(book);
    }

    @Override
    public void deleteBook(Integer bookId) {
        if (!bookRepository.existsById(Long.valueOf(bookId))) {
            throw new RuntimeException("Book not found with id: " + bookId);
        }
        bookRepository.deleteById(Long.valueOf(bookId));
    }
    @Override
    public String updateBookImage(Long bookId, String imageUrl) {
        Book book = bookRepository.findById(bookId).orElseThrow();
        book.setDescription(imageUrl);
        return imageUrl;
    }

    @Override
    public CategoryDTO addCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.name());
        return new CategoryDTO(categoryRepository.save(category).getCategoryId(), category.getName(), null);
    }

    @Override
    public CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));

        category.setName(categoryDTO.name());

        category = categoryRepository.save(category);
        return new CategoryDTO(category.getCategoryId(), category.getName(), null);
    }

    @Override
    public void deleteCategory(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new RuntimeException("Category not found with id: " + id);
        }
        categoryRepository.deleteById(id);
    }

    @Override
    public OrderDTO updateOrderStatus(Long orderId, String status) {
        Order order = orderRepository.findById(orderId).orElseThrow();
        order.setStatus(Status.valueOf(status));
        return new OrderDTO(order.getOrderId(), order.getStatus());
    }

    @Override
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(category -> new CategoryDTO(
                        category.getCategoryId(),
                        category.getName(),
                        category.getParentCategory()
                ))
                .toList(); // Преобразование потока в список
    }

    private BookDTO convertToDTO(Book book) {
        return new BookDTO(
                book.getBookId(),
                book.getTitle(),
                book.getAuthor().getId(),
                book.getCategory().getCategoryId(),
                book.getPrice(),
                book.getDiscount(),
                book.getStockQuantity(),
                book.getDescription(),
                book.getPublishedYear(),
                null
        );
    }
}

