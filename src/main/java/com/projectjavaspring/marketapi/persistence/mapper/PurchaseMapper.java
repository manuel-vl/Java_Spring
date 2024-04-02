package com.projectjavaspring.marketapi.persistence.mapper;

import com.projectjavaspring.marketapi.domain.Purchase;
import com.projectjavaspring.marketapi.persistence.entity.Compra;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

// El uses PurchaseItemMapper se encarga de mapear lo relacionado a comprasProductos
// componentModel = spring, nos garanzita que el modelo del componente es de Spring
@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {
    @Mappings({
            @Mapping(source = "idPurchase", target = "purchaseId"),
            @Mapping(source = "idCliente", target = "clientId"),
            @Mapping(source = "date", target = "date"),
            @Mapping(source = "paymentMethod", target = "paymentMethod"),
            @Mapping(source = "comment", target = "comment"),
            @Mapping(source = "state", target = "state"),
            @Mapping(source = "comprasProductos", target = "items"),
    })
    Purchase toPurchase(Compra compra);

    List<Purchase> toPurchases(List<Compra> compras);

    // Hace el mapeo inverso que definimos en el mapping
    @InheritInverseConfiguration
    @Mapping(target = "cliente", ignore = true)
    Compra toCompra(Purchase compra);
}
