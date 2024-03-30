package com.projectjavaspring.marketapi.domain;

import lombok.Data;

@Data
public class Product {
    private Integer productId;
    private String name;
    private Integer categoryId;
    private Double price;
    private Integer stock;
    private Integer active;
    private Category category;
}
