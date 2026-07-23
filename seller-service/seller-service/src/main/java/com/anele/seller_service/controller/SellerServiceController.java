package com.anele.seller_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SellerServiceController {
    @GetMapping("/")
    public String seller() {
        return "Seller service is running";
    }
}
