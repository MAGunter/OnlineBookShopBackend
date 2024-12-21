package com.kazakhi.onlinebookshop.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    private String title;
    @ManyToOne
    @JoinColumn(name = "authorId")
    private Author author;
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;
    private BigDecimal price;
    private BigDecimal discount;
    private Integer stockQuantity;
    @ManyToOne
    @JoinColumn(name = "currencyCode")
    private Currency currency;
    private String description;
    private Integer publishedYear;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private byte[] imageData;
}

