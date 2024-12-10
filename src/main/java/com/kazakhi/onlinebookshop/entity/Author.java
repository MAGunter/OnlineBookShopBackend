package com.kazakhi.onlinebookshop.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Author{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorId;
    private String name;
    @Lob
    private String biography;
    private String dateOfBirth;
}

