package com.projectjavaspring.marketapi.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name="CATEGORIES")
public class Categoria {
    @Id
    @Column(name="category_id")
    private Integer idCategory;

    private String description;

    private Integer state;

    // Relacion Uno a Muchos
    @OneToMany(mappedBy = "categoria")
    private Set<Producto> productos;
}
