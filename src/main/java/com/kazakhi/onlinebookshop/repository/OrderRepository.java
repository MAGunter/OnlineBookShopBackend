package com.kazakhi.onlinebookshop.repository;

import com.kazakhi.onlinebookshop.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
