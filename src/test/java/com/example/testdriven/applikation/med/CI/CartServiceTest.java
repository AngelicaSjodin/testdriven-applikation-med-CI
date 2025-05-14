package com.example.testdriven.applikation.med.CI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CartServiceTest {
    private CartRepository cartRepository;
    private CartService cartService;

    @BeforeEach
    void setUp(){
        cartRepository = mock(CartRepository.class);
        cartService = new CartService();
        cartService.cartRepository = cartRepository;
    }

    @Test
    void checksGetAllCartsReturnsCorrectList(){
        //Arrange
        Cart AngesCart = new Cart();
        Cart LinsCart = new Cart();
        when(cartRepository.findAll()).thenReturn(List.of(AngesCart,LinsCart));

        //Act
        List<Cart> carts = cartService.getAllCarts();

        //Assert
        assertEquals(2,carts.size());
        verify(cartRepository).findAll();
    }

    @Test
    void checksCreateCartReturnsSavedCart(){
        //Arrange
        Cart cart = new Cart();
        when(cartRepository.save(cart)).thenReturn(cart);

        //Act
        Cart savedCart = cartService.createCart(cart);

        //Assert
        assertEquals(cart,savedCart);
        verify(cartRepository).save(cart);
    }

}