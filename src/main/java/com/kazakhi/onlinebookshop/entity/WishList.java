package com.kazakhi.onlinebookshop.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer wishLitId;
    @ManyToOne
    @JoinColumn(name = "userId")
    private Users user;
    @ManyToOne
    @JoinColumn(name = "bookId")
    private Book book;
    private LocalDateTime addedAt;
}
