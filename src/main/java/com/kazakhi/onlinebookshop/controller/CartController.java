package com.kazakhi.onlinebookshop.controller;

import com.kazakhi.onlinebookshop.entity.Cart;
import com.kazakhi.onlinebookshop.service.CartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/cart")
@Tag(name = "Cart", description = "Cart operations")
@CrossOrigin(origins = "http://localhost:3000")

public class CartController {
    private final CartService cartService;

    @GetMapping
    @Operation(summary = "Get all cart items", description = "Get all cart items for a user")
    public List<Cart> getAllCartItems(Integer userId){
        return cartService.getCartItems(userId);
    }

    @PostMapping
    @Operation(summary = "Add to cart", description = "Add a book to the cart")
    public Cart addToCart(Integer userId, Long bookId, Integer quantity){
        return cartService.addToCart(userId, bookId, quantity);
    }

    @PutMapping("/{bookId}")
    @Operation(summary = "Update cart", description = "Update the quantity of a book in the cart")
    public Cart updateCart(@PathVariable Long bookId, Integer userId, Integer quantity){
        return cartService.updateCart(userId, bookId, quantity);
    }

    @DeleteMapping
    @Operation(summary = "Remove from cart", description = "Remove a book from the cart")
    public void removeFromCart(Integer userId, Long bookId){
        cartService.removeFromCart(userId, bookId);
    }
}
