package com.kazakhi.onlinebookshop.service;

import com.kazakhi.onlinebookshop.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(Long orderId);
    Order createOrder(Order order);
    void deleteOrder(Long orderId);
    void updateOrder(Long orderId);
}
