package com.kazakhi.onlinebookshop.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    private String title;
    @ManyToOne
    @JoinColumn
    private Author author;
    @ManyToOne
    @JoinColumn
    private Category category;
    private BigDecimal price;
    private BigDecimal discount;
    private Integer stockQuantity;
    @ManyToOne
    @JoinColumn
    private Currency currency;
    private String description;
    private Integer publishedYear;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String imageData;
}

