package com.kazakhi.onlinebookshop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer couponId;
    private String code;
    private BigDecimal discount;
    private Integer usageLimit;
    private boolean isActive;
    private LocalDateTime createdAt;
}
