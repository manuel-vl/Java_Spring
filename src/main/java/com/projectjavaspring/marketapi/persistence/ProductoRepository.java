package com.projectjavaspring.marketapi.persistence;

import com.projectjavaspring.marketapi.persistence.crud.IProductoCrudRepository;
import com.projectjavaspring.marketapi.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public class ProductoRepository {
    private IProductoCrudRepository productoCrudRepository;

    public ProductoRepository(IProductoCrudRepository productoCrudRepository) {
        this.productoCrudRepository = productoCrudRepository;
    }

    public List<Producto> getAllProducts(){
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getByCategory(int idCategory){
        return productoCrudRepository.findByIdCategoryOrderByNameAsc(idCategory);
    }

    public Optional<List<Producto>> getMinusStock(int stockQuantity, int state){
        return productoCrudRepository.findByStockQuantityLessThanAndState(stockQuantity, state);
    }
}
