package com.projectjavaspring.marketapi.web.controller;

import com.projectjavaspring.marketapi.domain.Product;
import com.projectjavaspring.marketapi.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{productId}")
    public Optional<Product> getProduct(@PathVariable("productId") int productId){
        return productService.getProduct(productId);
    }

    @GetMapping("/category/{categoryId}")
    public Optional<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId){
        return productService.getByCategory(categoryId);
    }

    @PostMapping("")
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }

    @DeleteMapping("/{productId}")
    public boolean delete(@PathVariable("productId") int productId){
        return productService.delete(productId);
    }
}
