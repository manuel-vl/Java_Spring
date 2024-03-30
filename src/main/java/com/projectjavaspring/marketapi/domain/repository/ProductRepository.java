package com.projectjavaspring.marketapi.domain.repository;

import com.projectjavaspring.marketapi.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScarseProducts(int quantity, int active);
    Optional<Product> getProductById(int productId);
    Product save(Product product);
    void delete(int productId);
}
