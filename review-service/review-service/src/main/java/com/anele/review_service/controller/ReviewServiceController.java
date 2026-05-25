package com.anele.review_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewServiceController {
    @GetMapping("/")
    public String review() {
        return "Review service is running";
    }
}
