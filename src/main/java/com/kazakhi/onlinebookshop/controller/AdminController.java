package com.kazakhi.onlinebookshop.controller;

import com.kazakhi.onlinebookshop.dto.BookDTO;
import com.kazakhi.onlinebookshop.dto.CategoryDTO;
import com.kazakhi.onlinebookshop.dto.StatisticsResponse;
import com.kazakhi.onlinebookshop.dto.OrderDTO;
import com.kazakhi.onlinebookshop.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@Tag(name = "Admin", description = "Admin operations")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/statistics")
    @Operation(summary = "Get statistics", description = "Get statistics for the online bookshop")
    public ResponseEntity<StatisticsResponse> getStatistics() {
        return ResponseEntity.ok(adminService.getStatistics());
    }

    @GetMapping("/books")
    @Operation(summary = "Get all books", description = "Get all books in the online bookshop")
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        return ResponseEntity.ok(adminService.getAllBooks());
    }

    @PostMapping("/books")
    @Operation(summary = "Add a book", description = "Add a book to the online bookshop")
    public ResponseEntity<BookDTO> addBook(@RequestBody BookDTO bookDTO) {
        return ResponseEntity.ok(adminService.addBook(bookDTO));
    }

    @PutMapping("/books/{bookId}")
    @Operation(summary = "Update a book", description = "Update a book in the online bookshop")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Integer bookId, @RequestBody BookDTO bookDTO) {
        return ResponseEntity.ok(adminService.updateBook(bookId, bookDTO));
    }

    @DeleteMapping("/books/{bookId}")
    @Operation(summary = "Delete a book", description = "Delete a book from the online bookshop")
    public ResponseEntity<Void> deleteBook(@PathVariable Integer bookId) {
        adminService.deleteBook(bookId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/books/{bookId}/image")
    @Operation(summary = "Update book image", description = "Update the image of a book in the online bookshop")
    public ResponseEntity<String> updateBookImage(@PathVariable Long bookId, @RequestBody String imageUrl) {
        return ResponseEntity.ok(adminService.updateBookImage(bookId, imageUrl));
    }

    @PostMapping("/categories")
    @Operation(summary = "Add a category", description = "Add a category to the online bookshop")
    public ResponseEntity<CategoryDTO> addCategory(@RequestBody CategoryDTO categoryDTO) {
        return ResponseEntity.ok(adminService.addCategory(categoryDTO));
    }

    @PutMapping("/categories/{id}")
    @Operation(summary = "Update a category", description = "Update a category in the online bookshop")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO) {
        return ResponseEntity.ok(adminService.updateCategory(id, categoryDTO));
    }

    @DeleteMapping("/categories/{id}")
    @Operation(summary = "Delete a category", description = "Delete a category from the online bookshop")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        adminService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/orders/{orderId}")
    @Operation(summary = "Update order status", description = "Update the status of an order in the online bookshop")
    public ResponseEntity<OrderDTO> updateOrderStatus(@PathVariable Long orderId, @RequestParam String status) {
        return ResponseEntity.ok(adminService.updateOrderStatus(orderId, status));
    }

    @DeleteMapping("/orders/{orderId}")
    @Operation(summary = "Delete an order", description = "Delete an order from the online bookshop")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
        adminService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }
}
