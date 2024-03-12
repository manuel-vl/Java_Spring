package com.projectjavaspring.marketapi.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Data
// Indicando que esta clase mapea una tabla de la DB
@Entity
// Nombre de la tabla en la DB
@Table(name="PURCHASES")
public class Compra {
    // Indicando que es clave primaria
    @Id
    // Como el atributo se llama diferente a la columna, agregamos la siguiente notacion
    @Column(name="purchase_id")
    private Integer idPurchase;

    @Column(name="client_id")
    private String idCliente;

    private LocalDateTime date;

    @Column(name="payment_method")
    private String paymentMethod;

    private String comment;

    private String state;

    // Relacion Muchos a Uno
    @ManyToOne
    // No permitimos crear clientes atraves de esta relacion
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Cliente cliente;

    // Relacion Uno a Muchos
    @OneToMany(mappedBy = "compra")
    private Set<ComprasProducto> comprasProductos;
}
