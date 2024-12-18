package com.kazakhi.onlinebookshop.service;

import com.kazakhi.onlinebookshop.entity.WishList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WishListService {
    void addToWithList(Long userId, Integer bookId);
    void removeFromWishList(Long userId, Integer bookId);
    List<WishList> getAllWishListItems(Long userId);
}
