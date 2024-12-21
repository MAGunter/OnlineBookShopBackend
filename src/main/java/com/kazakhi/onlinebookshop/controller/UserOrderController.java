package com.kazakhi.onlinebookshop.controller;

import com.kazakhi.onlinebookshop.dto.OrderDTO;
import com.kazakhi.onlinebookshop.entity.Order;
import com.kazakhi.onlinebookshop.service.OrderService;
import com.kazakhi.onlinebookshop.utility.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ApiResponse<List<Order>>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(new ApiResponse<>(orders, "Orders retrieved successfully"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Order>> getOrder(@PathVariable Long id) {
        Order order = orderService.getOrderById(id);
        return ResponseEntity.ok(new ApiResponse<>(order, "Order retrieved successfully"));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Order>> createOrder(@RequestBody OrderDTO orderRequest) {
        Order order = orderService.createOrder(orderRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(order, "Order created successfully"));
    }

    @PutMapping("/{orderId}")
    @Operation(summary = "Update an order", description = "Update an order")
    public ResponseEntity<Order> updateOrder(@PathVariable Long orderId) {
        orderService.updateOrder(orderId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{orderId}")
    @Operation(summary = "Delete an order", description = "Delete an order")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }
}


