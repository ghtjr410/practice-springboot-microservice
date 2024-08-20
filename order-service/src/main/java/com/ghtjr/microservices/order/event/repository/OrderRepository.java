package com.ghtjr.microservices.order.event.repository;

import com.ghtjr.microservices.order.event.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
