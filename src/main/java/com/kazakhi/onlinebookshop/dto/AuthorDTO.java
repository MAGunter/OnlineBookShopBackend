package com.kazakhi.onlinebookshop.dto;

import java.time.LocalDate;

public record AuthorDTO(Long id, String name, String biography, LocalDate dateOfBirth) {

}

