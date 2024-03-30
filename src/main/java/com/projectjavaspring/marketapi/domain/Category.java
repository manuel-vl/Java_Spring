package com.projectjavaspring.marketapi.domain;

import lombok.Data;

@Data
public class Category {
    private Integer categoryId;
    private String category;
    private Integer active;
}
