package com.kazakhi.onlinebookshop.service.impl;

import com.kazakhi.onlinebookshop.entity.Book;
import com.kazakhi.onlinebookshop.entity.Cart;
import com.kazakhi.onlinebookshop.entity.User;
import com.kazakhi.onlinebookshop.repository.CartRepository;
import com.kazakhi.onlinebookshop.service.BookService;
import com.kazakhi.onlinebookshop.service.CartService;
import com.kazakhi.onlinebookshop.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService{

    private final CartRepository cartRepository;
    private final BookService bookService;
    private final UserService userService;

    @Override
    public List<Cart> getCartItems(Integer userId) {
        return cartRepository.findByUser_UserId(userId);
    }

    @Override
    @Transactional
    public Cart addToCart(Long userId, Integer bookId, Integer quantity) {
        User user = userService.getUserById(userId);
        Book book = bookService.getBookById(bookId);
        Cart cart = cartRepository.findByUser_UserIdAndBook_BookId(user.getUserId(), book.getBookId())
                .orElse(new Cart());
        cart.setBook(book);
        cart.setUser(user);
        cart.setQuantity(quantity == null ? 1 : quantity);

        return cartRepository.save(cart);
    }

    @Override
    public Cart updateCart(Integer userId, Integer bookId, Integer quantity) {
        Cart cart = cartRepository.findByUser_UserIdAndBook_BookId(userId, bookId)
                .orElseThrow(() -> new RuntimeException("Cart item not found"));

        if(quantity <= 0){
            cartRepository.delete(cart);
            return null;
        }
        cart.setQuantity(quantity);
        return cartRepository.save(cart);
    }

    @Override
    @Transactional
    public void removeFromCart(Integer userId, Integer bookId) {
        cartRepository.deleteByUser_UserIdAndBook_BookId(userId, bookId);
    }

}
