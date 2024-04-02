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

    // Relacion Muchos a Uno
    @ManyToOne
    @MapsId("idPurchase")
    // No permitimos crear compra atraves de esta relacion
    @JoinColumn(name = "purchase_id", insertable = false, updatable = false)
    private Compra compra;

    // Relacion Muchos a Uno
    @ManyToOne
    // No permitimos crear producto a traves de esta relacion
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Producto producto;
}
