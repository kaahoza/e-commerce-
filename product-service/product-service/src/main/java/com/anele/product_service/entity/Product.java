package com.anele.product_service.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Product {
    public Long id;
    public String name;
    public String description;
    public String category;
    public String price;
    public String status;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;
}
