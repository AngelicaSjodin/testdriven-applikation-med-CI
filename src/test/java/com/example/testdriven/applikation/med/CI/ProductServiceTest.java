package com.example.testdriven.applikation.med.CI;

import com.fasterxml.jackson.core.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {
    private ProductRepository productRepository;
    private ProductService productService;

    @BeforeEach
    public void setUp(){
        productRepository = mock(ProductRepository.class);
        productService = new ProductService(productRepository);
    }

    //unit tests

    @Test
    void testCreateProductReturnsTheRightValue(){
        //arrange
        Product product = new Product("banana","info about banana");
        Product savedProduct = new Product("banana","info about banana");
        savedProduct.setId(1);

        //act
        when(productRepository.save(product)).thenReturn(savedProduct);

        Product result = productService.createProduct(product);
        //assert
        assertEquals(1,result.getId());
        assertEquals("banana",result.getName());
        verify(productRepository).save(product);
    }

    @Test
    void checksGetAllProductsReturnsCorrectListOfProducts(){
        Product apple = new Product("apple","apple info");
        Product banana = new Product("banana","banana info");

        when(productRepository.findAll()).thenReturn(List.of(apple,banana));
        List<Product> products = productService.getAllProducts();

        assertEquals(2,products.size());
        assertEquals("apple",products.get(0).getName());
        verify(productRepository).findAll();
    }

    @Test
    void checkingAProductExsistsWhenCallingGetProductById(){
        Product product = new Product("sten","info om sten");
        when(productRepository.findById(1)).thenReturn(Optional.of(product));

        Product result = productService.getProductById(1);

        assertEquals("sten",result.getName());
        verify(productRepository).findById(1);
    }

    @Test
    void checksGetProductByIdThrowsExcepionWhenProductNotFound(){
        when(productRepository.findById(2)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class,()-> productService.getProductById(2));
    }
}