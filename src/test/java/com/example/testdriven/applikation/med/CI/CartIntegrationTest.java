package com.example.testdriven.applikation.med.CI;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.hasSize;
import org.springframework.http.MediaType;

import java.util.List;


@SpringBootTest
@AutoConfigureMockMvc

public class CartIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartRepository cartRepository;


    @Test
    void checksCreateCartsProductsAndReturnIt() throws Exception{
        cartRepository.deleteAll();
        productRepository.deleteAll();

        Product apple = new Product("apple","Red thing");
        Product banana = new Product("banana","yellow thing");
        productRepository.saveAll(List.of(apple,banana));

        Cart cart = new Cart();
        cart.setProducts(List.of(apple,banana));

        mockMvc.perform(post("/carts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cart)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.products", hasSize(2)))
                .andExpect(jsonPath("$.products[0].name").value("apple"));

        mockMvc.perform(get("/carts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].products", hasSize(2)))
                .andExpect(jsonPath("$[0].products[1].name").value("banana"));
    }
}
