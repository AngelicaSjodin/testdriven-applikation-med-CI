package com.example.testdriven.applikation.med.CI;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Date;
import java.util.List;

@Entity
public class Order {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany
    private List<Product> products;

    private Date orderDate;

    public Order(){

    }

    public Order(Integer id, List<Product> products, Date orderDate) {
        this.id = id;
        this.products = products;
        this.orderDate = orderDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
