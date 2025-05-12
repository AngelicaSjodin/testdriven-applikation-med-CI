package com.example.testdriven.applikation.med.CI;

public class Product {

    Integer id;
    String name;
    String info;

    public Product(String name, String info, int id) {
        this.name = name;
        this.info = info;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
