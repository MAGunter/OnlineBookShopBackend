package com.kazakhi.onlinebookshop.controller;

import com.kazakhi.onlinebookshop.entity.Orders;
import com.kazakhi.onlinebookshop.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
@Tag(name = "Order", description = "Order operations")
@CrossOrigin(origins = "http://localhost:3000")

public class UserOrderController {
    private final OrderService orderService;

    @GetMapping
    @Operation(summary = "Get all orders", description = "Get all orders")
    public List<Orders> getAllOrder(){
        return orderService.getAllOrders();
    }

    @GetMapping("/{orderId}")
    @Operation(summary = "Get an order by ID", description = "Get an order by ID")
    public Orders getOrder(@PathVariable Long orderId){
        return orderService.getOrderById(orderId);
    }

    @PostMapping
    @Operation(summary = "Create an order", description = "Create an order")
    public Orders createOrder(@RequestBody Orders order){
        return orderService.createOrder(order);
    }
}

