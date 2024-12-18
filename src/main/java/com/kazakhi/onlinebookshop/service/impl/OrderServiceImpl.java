package com.kazakhi.onlinebookshop.service.impl;

import com.kazakhi.onlinebookshop.entity.Order;
import com.kazakhi.onlinebookshop.repository.OrderRepository;
import com.kazakhi.onlinebookshop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new NoSuchElementException("Order not found"));
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public void updateOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
                        .orElseThrow(() -> new NoSuchElementException("Order not found"));
        orderRepository.save(order);
    }
}
