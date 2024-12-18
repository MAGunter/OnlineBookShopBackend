package com.kazakhi.onlinebookshop.service.impl;

import com.kazakhi.onlinebookshop.entity.Book;
import com.kazakhi.onlinebookshop.entity.User;
import com.kazakhi.onlinebookshop.entity.WishList;
import com.kazakhi.onlinebookshop.repository.BookRepository;
import com.kazakhi.onlinebookshop.repository.UserRepository;
import com.kazakhi.onlinebookshop.repository.WishListRepository;
import com.kazakhi.onlinebookshop.service.WishListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WishListServiceImpl implements WishListService {
    private final WishListRepository wishListRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    @Override
    @Transactional
    public void addToWithList(Long userId, Integer bookId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Book book = bookRepository.findBookByBookId(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));

        boolean exists = wishListRepository.findByUserAndBook(user, book).isPresent();
        if (exists) {
            throw new IllegalStateException("Book is already in the wishlist");
        }

        WishList wishList = new WishList();
        wishList.setUser(user);
        wishList.setBook(book);
        wishList.setAddedAt(LocalDateTime.now());
        wishListRepository.save(wishList);
    }

    @Override
    @Transactional
    public void removeFromWishList(Long userId, Integer bookId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Book book = bookRepository.findBookByBookId(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));

        WishList wishList = wishListRepository.findByUserAndBook(user, book)
                .orElseThrow(() -> new IllegalArgumentException("WishList item not found"));

        wishListRepository.delete(wishList);
    }

    @Override
    @Transactional(readOnly = true)
    public List<WishList> getAllWishListItems(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        return wishListRepository.findByUser(user);
    }
}

