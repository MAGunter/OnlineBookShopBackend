package com.kazakhi.onlinebookshop.service.impl;

import com.kazakhi.onlinebookshop.dto.CouponDTO;
import com.kazakhi.onlinebookshop.entity.Coupon;
import com.kazakhi.onlinebookshop.repository.CouponRepository;
import com.kazakhi.onlinebookshop.service.CouponService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CouponServiceImpl implements CouponService {

    private final CouponRepository couponRepository;

    public CouponServiceImpl(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    @Override
    public CouponDTO createCoupon(CouponDTO couponDTO) {
        Coupon coupon = new Coupon();
        coupon.setCode(couponDTO.code());
        coupon.setDiscount(couponDTO.discount());
        coupon.setUsageLimit(couponDTO.usageLimit());
        coupon.setActive(couponDTO.isActive());
        coupon.setCreatedAt(LocalDateTime.now());

        coupon = couponRepository.save(coupon);
        return convertToDTO(coupon);
    }

    @Override
    public CouponDTO updateCoupon(Integer couponId, CouponDTO couponDTO) {
        Coupon coupon = couponRepository.findById(couponId)
                .orElseThrow(() -> new RuntimeException("Coupon not found with id: " + couponId));

        coupon.setCode(couponDTO.code());
        coupon.setDiscount(couponDTO.discount());
        coupon.setUsageLimit(couponDTO.usageLimit());
        coupon.setActive(couponDTO.isActive());
        coupon.setCreatedAt(LocalDateTime.now()); // Optional: Update timestamp

        return convertToDTO(couponRepository.save(coupon));
    }

    @Override
    public void deleteCoupon(Integer couponId) {
        if (!couponRepository.existsById(couponId)) {
            throw new RuntimeException("Coupon not found with id: " + couponId);
        }
        couponRepository.deleteById(couponId);
    }

    @Override
    public List<CouponDTO> getAllCoupons() {
        return couponRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CouponDTO getCouponById(Integer couponId) {
        Coupon coupon = couponRepository.findById(couponId)
                .orElseThrow(() -> new RuntimeException("Coupon not found with id: " + couponId));
        return convertToDTO(coupon);
    }

    private CouponDTO convertToDTO(Coupon coupon) {
        return new CouponDTO(
                coupon.getCouponId(),
                coupon.getCode(),
                coupon.getDiscount(),
                coupon.getUsageLimit(),
                coupon.isActive()
        );
    }
}
