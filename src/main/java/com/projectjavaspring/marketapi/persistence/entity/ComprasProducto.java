package com.projectjavaspring.marketapi.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="PURCHASES_PRODUCTS")
public class ComprasProducto {
    // Esta clase tiene 2 Pk, y las agregamos en la clase ComprasProductoPK (Como es compuesta y dada por otra clase usamos EmbeddedId)
    @EmbeddedId
    private ComprasProductoPK id;

    private Integer quantity;

    private Double total;

    private Integer state;
}
