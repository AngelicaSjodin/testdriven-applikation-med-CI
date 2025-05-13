package com.example.testdriven.applikation.med.CI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @GetMapping
    public List<Cart> getAllCarts(){
        return cartRepository.findAll();
    }

    @PostMapping
    public Cart createCart(@RequestBody Cart cart){
        return cartRepository.save(cart);
    }
}
