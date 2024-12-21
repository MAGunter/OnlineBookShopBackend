package com.kazakhi.onlinebookshop.controller;

import com.kazakhi.onlinebookshop.dto.AuthorDTO;
import com.kazakhi.onlinebookshop.service.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Tag(name = "Author", description = "Authors management")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/authors")
    @Operation(summary = "Get all authors", description = "Get all authors in the online bookshop")
    public ResponseEntity<List<AuthorDTO>> getAllAuthors() {
        return ResponseEntity.ok(authorService.getAllAuthors());
    }

    @GetMapping("/authors/{authorId}")
    @Operation(summary = "Get author by ID", description = "Get author by ID")
    public ResponseEntity<AuthorDTO> getAuthorById(@PathVariable Long authorId) {
        return ResponseEntity.ok(authorService.getAuthorById(authorId));
    }

    @PostMapping("/admin/authors")
    @Operation(summary = "Create an author", description = "Create an author in the online bookshop")
    public ResponseEntity<AuthorDTO> createAuthor(@RequestBody AuthorDTO authorDTO) {
        return ResponseEntity.ok(authorService.createAuthor(authorDTO));
    }

    @PutMapping("/admin/authors/{id}")
    @Operation(summary = "Update an author", description = "Update an author in the online bookshop")
    public ResponseEntity<AuthorDTO> updateAuthor(@PathVariable Long id, @RequestBody AuthorDTO authorDTO) {
        return ResponseEntity.ok(authorService.updateAuthor(id, authorDTO));
    }

    @DeleteMapping("/admin/authors/{id}")
    @Operation(summary = "Delete an author", description = "Delete an author from the online bookshop")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }
}
