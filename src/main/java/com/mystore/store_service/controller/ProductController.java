package com.mystore.store_service.controller;

import com.mystore.store_service.model.Product;
import com.mystore.store_service.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product){
        return ResponseEntity.ok(service.addProduct(product));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id){
        return ResponseEntity.ok(service.getProduct(id));
    }
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok(service.getAllProducts());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id,@Valid @RequestBody Product product){
        return ResponseEntity.ok(service.updateProduct(id,product));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        service.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

}
