package com.kazakhi.onlinebookshop.service;

import com.kazakhi.onlinebookshop.entity.Cart;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {
    List<Cart> getCartItems(Integer userId);
    Cart addToCart(Long userId, Integer bookId, Integer quantity);
    Cart updateCart(Integer userId, Integer bookId, Integer quantity);
    void removeFromCart(Integer userId, Integer bookId);
}
