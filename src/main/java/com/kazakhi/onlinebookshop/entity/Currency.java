package com.kazakhi.onlinebookshop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class Currency {
    @Id
    @Column(length = 10)
    private String currencyCode;
    @Column(nullable = false)
    private BigDecimal exchangeRate;
    private LocalDateTime updatedAt = LocalDateTime.now();
}
