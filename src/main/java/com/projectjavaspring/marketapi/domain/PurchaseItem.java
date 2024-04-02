package com.projectjavaspring.marketapi.domain;

import lombok.Data;

@Data
public class PurchaseItem {
    private Integer productId;
    private Integer quantity;
    private Double total;
    private Integer state;
}
