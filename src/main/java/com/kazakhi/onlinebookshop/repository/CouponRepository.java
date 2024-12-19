package com.kazakhi.onlinebookshop.repository;

import com.kazakhi.onlinebookshop.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {
}

