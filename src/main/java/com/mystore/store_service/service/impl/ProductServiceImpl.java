package com.mystore.store_service.service.impl;

import com.mystore.store_service.model.Product;
import com.mystore.store_service.repository.ProductRepository;
import com.mystore.store_service.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository){
        this.repository = repository;
    }

    @Override
    public Product addProduct(Product product){
        return repository.save(product);
    }
    @Override
    public Product getProduct(Long id){
        return repository.findById(id).orElseThrow(()->
                new RuntimeException("Product not found with id "+id));
    }
    @Override
    public List<Product> getAllProducts(){
        return repository.findAll();
    }
    @Override
    public Product updateProduct(Long id, Product product){
        Product existing = getProduct(id);
        existing.setName(product.getName());
        existing.setDescription(product.getDescription());
        existing.setPrice(product.getPrice());
        existing.setStock(product.getStock());
        return repository.save(existing);
    }
    @Override
    public void deleteProduct(Long id){
        repository.deleteById(id);
    }
}
