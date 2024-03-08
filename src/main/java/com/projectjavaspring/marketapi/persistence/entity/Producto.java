package com.projectjavaspring.marketapi.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
// Indicando que esta clase mapea una tabla de la DB
@Entity
// Nombre de la tabla en la DB
@Table(name="PRODUCTS")
public class Producto {
    // Indicando que es clave primaria
    @Id
    // Como el atributo se llama diferente a la columna, agregamos la siguiente notacion
    @Column(name="product_id")
    private Integer idProduct;

    private String name;

    @Column(name="category_id")
    private Integer idCategory;

    private String barcode;

    private Double price;

    @Column(name="stock_quantity")
    private Integer stockQuantity;

    private Integer state;
}
