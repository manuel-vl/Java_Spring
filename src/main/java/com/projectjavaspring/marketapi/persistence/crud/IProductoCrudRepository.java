package com.projectjavaspring.marketapi.persistence.crud;

import com.projectjavaspring.marketapi.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IProductoCrudRepository extends CrudRepository<Producto, Integer> {
    // FORMA NATIVA
    //    @Query(value = "SELECT * FROM PRODUCTS WHERE category_id = ?", nativeQuery = true)
    //    List<Producto> queryToGetByIdCategory(int idCategory);

    // QUERY METHODS
    List<Producto> findByIdCategoryOrderByNameAsc(int idCategory);

    Optional<List<Producto>> findByStockQuantityLessThanAndState(int stockQuantity, int state);
}
