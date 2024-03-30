package com.projectjavaspring.marketapi.persistence;

import com.projectjavaspring.marketapi.domain.Product;
import com.projectjavaspring.marketapi.domain.repository.ProductRepository;
import com.projectjavaspring.marketapi.persistence.crud.IProductoCrudRepository;
import com.projectjavaspring.marketapi.persistence.entity.Producto;
import com.projectjavaspring.marketapi.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {
    private IProductoCrudRepository productoCrudRepository;
    private ProductMapper mapper;

    public ProductoRepository(IProductoCrudRepository productoCrudRepository) {
        this.productoCrudRepository = productoCrudRepository;
    }

    @Override
    public List<Product> getAll() {
        List<Producto> productos= (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos=productoCrudRepository.findByIdCategoryOrderByNameAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity, int active) {
        Optional <List<Producto>> productos=productoCrudRepository.findByStockQuantityLessThanAndState(quantity, active);
        return productos.map(prods->mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProductById(int productId) {
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        Producto producto=mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int productId) {
        productoCrudRepository.deleteById(productId);
    }
}
