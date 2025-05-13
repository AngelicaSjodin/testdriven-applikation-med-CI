package com.example.testdriven.applikation.med.CI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }


    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
   
}
