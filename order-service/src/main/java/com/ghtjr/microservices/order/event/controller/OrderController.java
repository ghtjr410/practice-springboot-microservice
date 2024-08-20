package com.ghtjr.microservices.order.event.controller;

import com.ghtjr.microservices.order.event.dto.OrderRequest;
import com.ghtjr.microservices.order.event.servcie.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
        log.info("Received OrderRequest: {}", orderRequest);
        orderService.placeOrder(orderRequest);
        return "Order Placed Successfully";
    }
}
