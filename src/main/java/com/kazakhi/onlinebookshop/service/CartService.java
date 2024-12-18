package com.kazakhi.onlinebookshop.service;

import com.kazakhi.onlinebookshop.entity.Cart;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {
    List<Cart> getCartItems(Integer userId);
    Cart addToCart(Integer userId, Long bookId, Integer quantity);
    Cart updateCart(Integer userId, Long bookId, Integer quantity);
    void removeFromCart(Integer userId, Long bookId);
}
