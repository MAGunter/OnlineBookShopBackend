package com.kazakhi.onlinebookshop.repository;

import com.kazakhi.onlinebookshop.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
