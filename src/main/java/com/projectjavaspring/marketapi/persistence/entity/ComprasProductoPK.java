package com.projectjavaspring.marketapi.persistence.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
// Esta clase se va a embeber en ComprasProducto
@Embeddable
// Esta clase no mapea una tabla
public class ComprasProductoPK implements Serializable {
    @Column(name="purchase_id")
    private Integer idPurchase;

    @Column(name="product_id")
    private Integer idProduct;
}
