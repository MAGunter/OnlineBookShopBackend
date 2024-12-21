package com.kazakhi.onlinebookshop.controller;

import com.kazakhi.onlinebookshop.dto.CouponDTO;
import com.kazakhi.onlinebookshop.service.CouponService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/coupons")
@RequiredArgsConstructor
@Tag(name = "Coupon", description = "Coupon management")
@CrossOrigin(origins = "http://localhost:3000")
public class CouponController {

    private final CouponService couponService;

    @PostMapping
    @Operation(summary = "Create a coupon", description = "Create a coupon")
    public ResponseEntity<CouponDTO> createCoupon(@RequestBody CouponDTO couponDTO) {
        return ResponseEntity.ok(couponService.createCoupon(couponDTO));
    }

    @PutMapping("/{couponId}")
    @Operation(summary = "Update a coupon", description = "Update a coupon")
    public ResponseEntity<CouponDTO> updateCoupon(@PathVariable Integer couponId, @RequestBody CouponDTO couponDTO) {
        return ResponseEntity.ok(couponService.updateCoupon(couponId, couponDTO));
    }

    @DeleteMapping("/{couponId}")
    @Operation(summary = "Delete a coupon", description = "Delete a coupon")
    public ResponseEntity<Void> deleteCoupon(@PathVariable Integer couponId) {
        couponService.deleteCoupon(couponId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @Operation(summary = "Get all coupons", description = "Get all coupons")
    public ResponseEntity<List<CouponDTO>> getAllCoupons() {
        return ResponseEntity.ok(couponService.getAllCoupons());
    }

    @GetMapping("/{couponId}")
    @Operation(summary = "Get a coupon by ID", description = "Get a coupon by ID")
    public ResponseEntity<CouponDTO> getCouponById(@PathVariable Integer couponId) {
        return ResponseEntity.ok(couponService.getCouponById(couponId));
    }
}
