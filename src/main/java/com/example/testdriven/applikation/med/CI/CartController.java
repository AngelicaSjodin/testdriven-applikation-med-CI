package com.example.testdriven.applikation.med.CI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping
    public List<Cart> getAllCarts(){
        return cartService.getAllCarts();
    }

    @PostMapping
    public Cart createCart(@RequestBody Cart cart){
        return cartService.createCart(cart);
    }
}
