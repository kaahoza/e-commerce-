package com.anele.product_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductServiceController {
    @GetMapping("/")
    public String products() {
        return "Product service is running";
    }
}
