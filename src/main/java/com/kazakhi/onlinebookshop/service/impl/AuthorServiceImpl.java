package com.kazakhi.onlinebookshop.service.impl;

import com.kazakhi.onlinebookshop.dto.AuthorDTO;
import com.kazakhi.onlinebookshop.entity.Author;
import com.kazakhi.onlinebookshop.repository.AuthorRepository;
import com.kazakhi.onlinebookshop.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public List<AuthorDTO> getAllAuthors() {
        return authorRepository.findAll().stream()
                .map(author -> new AuthorDTO(author.getId(), author.getName(), author.getBiography(), author.getDateOfBirth()))
                .collect(Collectors.toList());
    }

    @Override
    public AuthorDTO getAuthorById(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
        return new AuthorDTO(author.getId(), author.getName(), author.getBiography(), author.getDateOfBirth());
    }

    @Override
    public AuthorDTO createAuthor(AuthorDTO authorDTO) {
        LocalDate dateOfBirth = LocalDate.parse(authorDTO.dateOfBirth().toString()); // Исправление
        Author author = new Author(
                authorDTO.name(),
                authorDTO.biography(),
                dateOfBirth
        );
        author = authorRepository.save(author);
        return new AuthorDTO(author.getId(), author.getName(), author.getBiography(), author.getDateOfBirth());
    }


    @Override
    public AuthorDTO updateAuthor(Long id, AuthorDTO authorDTO) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        author.setName(authorDTO.name());
        author.setBiography(authorDTO.biography());
        author.setDateOfBirth(LocalDate.parse(authorDTO.dateOfBirth().toString())); // Исправление

        author = authorRepository.save(author);
        return new AuthorDTO(author.getId(), author.getName(), author.getBiography(), author.getDateOfBirth());
    }

    @Override
    public void deleteAuthor(Long id) {
        if (!authorRepository.existsById(id)) {
            throw new RuntimeException("Author not found");
        }
        authorRepository.deleteById(id);
    }
}

