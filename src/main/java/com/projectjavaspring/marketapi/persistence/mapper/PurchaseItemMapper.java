package com.projectjavaspring.marketapi.persistence.mapper;

import com.projectjavaspring.marketapi.domain.PurchaseItem;
import com.projectjavaspring.marketapi.persistence.entity.ComprasProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

// El uses ProductMapper se encarga de mapear lo relacionado a producto
// componentModel = spring, nos garanzita que el modelo del componente es de Spring
@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {
    // Si los atributos se llaman igual, podemos eliminar toda la linea (No es necesario agregar)
    @Mappings({
            @Mapping(source = "id.idProduct", target = "productId"),
            @Mapping(source = "quantity", target = "quantity"),
            @Mapping(source = "total", target = "total"),
            @Mapping(source = "state", target = "state"),
    })
    PurchaseItem toPurchaseItem(ComprasProducto producto);

    // Hace el mapeo inverso que definimos en el mappings
    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "compra", ignore = true),
            @Mapping(target = "producto", ignore = true),
            @Mapping(target = "id.idPurchase", ignore = true)
    })
    ComprasProducto toCompasProducto(PurchaseItem product);
}
