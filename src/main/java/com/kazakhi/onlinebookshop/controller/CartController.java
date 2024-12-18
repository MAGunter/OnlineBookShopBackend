package com.kazakhi.onlinebookshop.controller;

import com.kazakhi.onlinebookshop.entity.Cart;
import com.kazakhi.onlinebookshop.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/cart")
public class CartController {
    private final CartService cartService;

    @GetMapping
    public List<Cart> getAllCartItems(Integer userId){
        return cartService.getCartItems(userId);
    }

    @PostMapping
    public Cart addToCart(Integer userId, Long bookId, Integer quantity){
        return cartService.addToCart(userId, bookId, quantity);
    }

    @PutMapping("/{bookId}")
    public Cart updateCart(@PathVariable Long bookId, Integer userId, Integer quantity){
        return cartService.updateCart(userId, bookId, quantity);
    }

    @DeleteMapping
    public void removeFromCart(Integer userId, Long bookId){
        cartService.removeFromCart(userId, bookId);
    }
}
