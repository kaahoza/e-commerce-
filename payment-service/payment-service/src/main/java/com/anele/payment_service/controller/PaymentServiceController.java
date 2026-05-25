package com.anele.payment_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentServiceController {
    @GetMapping("/")
    public String payment(){
        return "Payment method is running";
    }

}
