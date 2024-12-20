package com.kazakhi.onlinebookshop.controller;

import com.kazakhi.onlinebookshop.entity.Book;
import com.kazakhi.onlinebookshop.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/books")
@RequiredArgsConstructor
@Tag(name = "Book", description = "Book operations")
public class BookController {

    private final BookService bookService;

    @GetMapping
    @Operation(summary = "Get all books", description = "Get all books in the online bookshop")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("{bookId}")
    @Operation(summary = "Get a book by ID", description = "Get a book by ID from the online bookshop")
    public Book getBookById(@PathVariable Long bookId){
        return bookService.getBookById(bookId);
    }

    @GetMapping("{bookId}/image")
    @Operation(summary = "Get book image", description = "Get the image of a book from the online bookshop")
    public byte[] getBookImage(@PathVariable Integer bookId){
        return bookService.getBookImage(bookId);
    }

}
