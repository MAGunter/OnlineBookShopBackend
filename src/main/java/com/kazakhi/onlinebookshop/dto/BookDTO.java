package com.kazakhi.onlinebookshop.dto;

import java.math.BigDecimal;

public record BookDTO(Long bookId, String title, Long authorId, Integer categoryId, BigDecimal price, BigDecimal discount, Integer stockQuantity, String description, Integer publishedYear, String imageUrl) {
}
