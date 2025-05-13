package com.example.testdriven.applikation.med.CI;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(Integer id){
        return productRepository.findById(id).orElseThrow(()-> new RuntimeException("product not foundd"));
    }
}
