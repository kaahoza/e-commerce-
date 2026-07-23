package com.anele.catalog_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatalogController {
    @GetMapping("/")
    public String catalog(){
        return "Catalog service is running";
    }
}
