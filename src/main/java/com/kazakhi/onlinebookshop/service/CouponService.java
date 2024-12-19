package com.kazakhi.onlinebookshop.service;

import com.kazakhi.onlinebookshop.dto.CouponDTO;

import java.util.List;

public interface CouponService {
    CouponDTO createCoupon(CouponDTO couponDTO);
    CouponDTO updateCoupon(Integer couponId, CouponDTO couponDTO);
    void deleteCoupon(Integer couponId);
    List<CouponDTO> getAllCoupons();
    CouponDTO getCouponById(Integer couponId);
}
