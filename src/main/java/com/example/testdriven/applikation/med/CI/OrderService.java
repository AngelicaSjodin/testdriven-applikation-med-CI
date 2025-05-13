package com.example.testdriven.applikation.med.CI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Order createOrder(Order order){
        order.setOrderDate(new Date());
        return orderRepository.save(order);
    }
}
