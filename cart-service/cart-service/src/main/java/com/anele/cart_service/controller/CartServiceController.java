package com.anele.cart_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartServiceController {
    @GetMapping("/")
        public String cart() {
            return "Cart service is running";
    }

}
