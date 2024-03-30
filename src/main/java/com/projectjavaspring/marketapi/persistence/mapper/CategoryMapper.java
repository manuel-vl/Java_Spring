package com.projectjavaspring.marketapi.persistence.mapper;

import com.projectjavaspring.marketapi.domain.Category;
import com.projectjavaspring.marketapi.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategory", target = "categoryId"),
            @Mapping(source = "description", target = "category"),
            @Mapping(source = "state", target = "active"),
    })
    Category toCategory(Categoria categoria);

    // Hace el mapeo inverso que definimos en el mappings
    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);

}
