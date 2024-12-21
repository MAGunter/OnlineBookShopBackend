package com.kazakhi.onlinebookshop.service;
import com.kazakhi.onlinebookshop.entity.Orders;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    List<Orders> getAllOrders();
    Orders getOrderById(Long orderId);
    Orders createOrder(Orders order);
    void deleteOrder(Long orderId);
    void updateOrder(Long orderId);
}
