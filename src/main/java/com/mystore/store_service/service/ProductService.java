package com.mystore.store_service.service;

import com.mystore.store_service.model.Product;

import java.util.List;

public interface ProductService {
    Product addProduct(Product product);
    Product getProduct(Long id);
    List<Product> getAllProducts();
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
}
