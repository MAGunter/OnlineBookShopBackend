package com.kazakhi.onlinebookshop.service.impl;

import com.kazakhi.onlinebookshop.entity.Book;
import com.kazakhi.onlinebookshop.repository.BookRepository;
import com.kazakhi.onlinebookshop.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final Path imageStorageLocation = Paths.get("images").toAbsolutePath().normalize();

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Integer bookId) {
        return bookRepository.findBookByBookId(bookId);
    }

    @Override
    public byte[] getBookImage(Integer bookId) {
        try{
            Path filePath = imageStorageLocation.resolve(bookId + " .jpg").normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(!resource.exists()){
                throw new IllegalArgumentException("Image not found for book ID: " + bookId);
            }
            return resource.getInputStream().readAllBytes();
        }catch(Exception ex){
            throw new RuntimeException("Error reading image file", ex);
        }
    }

}
