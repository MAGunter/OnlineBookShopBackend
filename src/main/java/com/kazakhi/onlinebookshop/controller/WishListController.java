package com.kazakhi.onlinebookshop.controller;

import com.kazakhi.onlinebookshop.entity.WishList;
import com.kazakhi.onlinebookshop.service.WishListService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wishlist")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class WishListController {
    private final WishListService wishListService;

    @GetMapping
    @Operation(summary = "Get all wishlist items", description = "Get all wishlist items for a user")
    public ResponseEntity<List<WishList>> getAllWishListItems(@RequestParam Long userId) {
        List<WishList> wishListItems = wishListService.getAllWishListItems(userId);
        return ResponseEntity.ok(wishListItems);
    }

    @PostMapping
    @Operation(summary = "Add to wishlist", description = "Add a book to the wishlist")
    public ResponseEntity<String> addToWishList(@RequestParam Long userId, @RequestParam Integer bookId) {
        wishListService.addToWithList(userId, bookId);
        return ResponseEntity.ok("Book added to wishlist successfully.");
    }

    @DeleteMapping("/{bookId}")
    @Operation(summary = "Remove from wishlist", description = "Remove a book from the wishlist")
    public ResponseEntity<String> removeFromWishList(@RequestParam Long userId, @PathVariable Integer bookId) {
        wishListService.removeFromWishList(userId, bookId);
        return ResponseEntity.ok("Book removed from wishlist successfully.");
    }
}

