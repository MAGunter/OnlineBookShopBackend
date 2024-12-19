package com.kazakhi.onlinebookshop.controller;

import com.kazakhi.onlinebookshop.dto.CouponDTO;
import com.kazakhi.onlinebookshop.service.CouponService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/coupons")
public class CouponController {

    private final CouponService couponService;

    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @PostMapping
    public ResponseEntity<CouponDTO> createCoupon(@RequestBody CouponDTO couponDTO) {
        return ResponseEntity.ok(couponService.createCoupon(couponDTO));
    }

    @PutMapping("/{couponId}")
    public ResponseEntity<CouponDTO> updateCoupon(@PathVariable Integer couponId, @RequestBody CouponDTO couponDTO) {
        return ResponseEntity.ok(couponService.updateCoupon(couponId, couponDTO));
    }

    @DeleteMapping("/{couponId}")
    public ResponseEntity<Void> deleteCoupon(@PathVariable Integer couponId) {
        couponService.deleteCoupon(couponId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<CouponDTO>> getAllCoupons() {
        return ResponseEntity.ok(couponService.getAllCoupons());
    }

    @GetMapping("/{couponId}")
    public ResponseEntity<CouponDTO> getCouponById(@PathVariable Integer couponId) {
        return ResponseEntity.ok(couponService.getCouponById(couponId));
    }
}
