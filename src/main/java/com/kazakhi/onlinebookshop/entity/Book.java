package com.kazakhi.onlinebookshop.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Books")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BookID", nullable = false)
    private Integer bookId;

    @Column(name = "Title", length = 255, nullable = false)
    private String title;

    @Column(name = "AuthorID", nullable = false)
    private Integer authorId;

    @Column(name = "CategoryID", nullable = false)
    private Integer categoryId;

    @Column(name = "Price", precision = 10, scale = 2, nullable = false)
    private BigDecimal price;

    @Column(name = "Discount", precision = 5, scale = 2)
    private BigDecimal discount;

    @Column(name = "StockQuantity", nullable = false)
    private Integer stockQuantity;

    @Column(name = "CurrencyCode", length = 10, nullable = false)
    private String currencyCode;

    @Column(name = "Description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "PublishedYear", columnDefinition = "YEAR", nullable = false)
    private Integer publishedYear;

    @Column(name = "CreatedAt", columnDefinition = "DATETIME", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "UpdatedAt", columnDefinition = "DATETIME")
    private LocalDateTime updatedAt;
}

