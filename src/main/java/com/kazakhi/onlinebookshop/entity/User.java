package com.kazakhi.onlinebookshop.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    private String passwordHash;
    private String phone;
    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;
    private LocalDateTime createdAt;
    private boolean isActive;
    private String avatarUrl;
}
