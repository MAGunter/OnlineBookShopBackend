package com.kazakhi.onlinebookshop.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
public class Author{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Lob
    private String biography;
    @Column(columnDefinition = "DATE")
    private LocalDate dateOfBirth;

    public Author(String name, String biography, LocalDate dateOfBirth) {
        this.name = name;
        this.biography = biography;
        this.dateOfBirth = dateOfBirth;
    }
}

