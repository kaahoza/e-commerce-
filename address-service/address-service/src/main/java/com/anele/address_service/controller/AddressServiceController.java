package com.anele.address_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressServiceController {
    @GetMapping("/")
    public String address() {
        return "Address service is running";
    }
}
