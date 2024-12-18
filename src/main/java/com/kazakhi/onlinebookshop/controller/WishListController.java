package com.kazakhi.onlinebookshop.controller;

import com.kazakhi.onlinebookshop.entity.WishList;
import com.kazakhi.onlinebookshop.service.WishListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wishlist")
@RequiredArgsConstructor
public class WishListController {
    private final WishListService wishListService;

    @GetMapping
    public ResponseEntity<List<WishList>> getAllWishListItems(@RequestParam Long userId) {
        List<WishList> wishListItems = wishListService.getAllWishListItems(userId);
        return ResponseEntity.ok(wishListItems);
    }

    @PostMapping
    public ResponseEntity<String> addToWishList(@RequestParam Long userId, @RequestParam Integer bookId) {
        wishListService.addToWithList(userId, bookId);
        return ResponseEntity.ok("Book added to wishlist successfully.");
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<String> removeFromWishList(@RequestParam Long userId, @PathVariable Integer bookId) {
        wishListService.removeFromWishList(userId, bookId);
        return ResponseEntity.ok("Book removed from wishlist successfully.");
    }
}

