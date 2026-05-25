package com.anele.product_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ProductServiceController {
    @GetMapping
    public String getProducts() {
        return "Product service is running";
    }
}
