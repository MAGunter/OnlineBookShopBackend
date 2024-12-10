package com.kazakhi.onlinebookshop.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reviewId;
    @ManyToOne
    @JoinColumn(name = "bookId")
    private Book book;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    private short rating;
    @Lob
    private String comment;
    private LocalDateTime createdAt = LocalDateTime.now();
}
