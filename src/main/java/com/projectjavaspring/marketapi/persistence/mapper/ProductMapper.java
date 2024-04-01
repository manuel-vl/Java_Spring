package com.projectjavaspring.marketapi.persistence.mapper;

import com.projectjavaspring.marketapi.domain.Product;
import com.projectjavaspring.marketapi.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

// El uses CategoryMapper se encarga de mapear lo relacionado a category
// componentModel = spring, nos garanzita que el modelo del componente es de Spring
@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "idProduct", target = "productId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "idCategory", target = "categoryId"),
            @Mapping(source = "price", target = "price"),
            @Mapping(source = "stockQuantity", target = "stock"),
            @Mapping(source = "state", target = "active"),
            @Mapping(source = "categoria", target = "category"),
    })
    Product toProduct(Producto producto);

    List<Product> toProducts(List<Producto> productos);

    // Hace el mapeo inverso que definimos en el mappings
    @InheritInverseConfiguration
    @Mapping(target = "barcode", ignore = true)
    Producto toProducto(Product product);
}
