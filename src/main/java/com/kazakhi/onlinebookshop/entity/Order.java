package com.kazakhi.onlinebookshop.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    private BigDecimal totalAmount;
    @ManyToOne
    @JoinColumn(name = "currencyCode")
    private Currency currencyCode;
    private Status status;
    private String shippingAddress;
    private Integer CouponId;
    private LocalDateTime createdAt;
}
