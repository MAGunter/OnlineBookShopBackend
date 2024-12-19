package com.kazakhi.onlinebookshop.dto;

import java.math.BigDecimal;

public record CouponDTO(Integer couponId, String code, BigDecimal discount, Integer usageLimit, boolean isActive) {
}
