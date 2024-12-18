package com.kazakhi.onlinebookshop.controller;


import com.kazakhi.onlinebookshop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/orders")
public class AdminOrderController {
    private final OrderService orderService;
    
    @PutMapping("/{orderId}")
    public void updateOrder(@PathVariable Long orderId){
        orderService.updateOrder(orderId);
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable Long orderId){
        orderService.deleteOrder(orderId);
    }
}
