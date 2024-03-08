package com.projectjavaspring.marketapi.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="CATEGORIES")
public class Categoria {
    @Id
    @Column(name="category_id")
    private Integer idCategory;

    private String description;

    private Integer state;
}
