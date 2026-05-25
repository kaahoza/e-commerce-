package com.anele.order_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderServiceController {
    @GetMapping("/")
    public String orders() {
        return "Order Service is running";
    }
}
