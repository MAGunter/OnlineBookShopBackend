package com.kazakhi.onlinebookshop.controller;

import com.kazakhi.onlinebookshop.entity.Order;
import com.kazakhi.onlinebookshop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class UserOrderController {
    private final OrderService orderService;

    @GetMapping
    public List<Order> getAllOrder(){
        return orderService.getAllOrders();
    }

    @GetMapping("/{orderId}")
    public Order getOrder(@PathVariable Long orderId){
        return orderService.getOrderById(orderId);
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order){
        return orderService.createOrder(order);
    }
}

