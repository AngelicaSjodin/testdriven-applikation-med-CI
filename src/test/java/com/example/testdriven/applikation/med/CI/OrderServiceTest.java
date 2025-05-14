package com.example.testdriven.applikation.med.CI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class OrderServiceTest {

    private OrderRepository orderRepository;
    private OrderService orderService;

    @BeforeEach
    void setUp(){
        orderRepository = mock(OrderRepository.class);
        orderService = new OrderService();
        orderService.orderRepository = orderRepository;
    }

    @Test
    void checksCreateOrderSetsDateAndSavesOrder(){
        //Arrange
        Order order = new Order();
        when(orderRepository.save(any(Order.class))).thenAnswer(invocation -> invocation.getArgument(0));

        //Act
        Order savedOrder = orderService.createOrder(order);
        //Assert

        assertNotNull(savedOrder.getOrderDate());
        verify(orderRepository).save(order);
    }

    @Test
    void checksIfGetAllOrdersReturnsCorrectList(){
        //Arrange
        Order JennysOrder = new Order();
        Order OllesOrder = new Order();
        when(orderRepository.findAll()).thenReturn(List.of(JennysOrder,OllesOrder));

        //Act
        List<Order> orders = orderService.getAllOrders();

        //Assert
        assertEquals(2,orders.size());
        verify(orderRepository).findAll();

    }
}
