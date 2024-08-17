package com.ghtjr.microservices.order.repository;

import com.ghtjr.microservices.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
