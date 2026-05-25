package com.anele.customer_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerServiceController {
    @GetMapping("/")
    public String customer() {
        return "Customer service is running";
    }
}
