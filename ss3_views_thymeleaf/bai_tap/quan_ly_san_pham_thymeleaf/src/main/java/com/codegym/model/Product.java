package com.codegym.model;

public class Product {
    private Integer id;
    private String name;
    private Double price;
    private String description;
    private String manufactor;
    static Integer lastProductId = 0;

    public Product() {

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufactor() {
        return manufactor;
    }

    public void setManufactor(String manufactor) {
        this.manufactor = manufactor;
    }

    public Product(Integer id, String name, Double price, String description, String manufactor) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.manufactor = manufactor;
        lastProductId++;
    }

    public Product(Product another) {
        this.id = another.getId();
        this.name = another.getName();
        this.price = another.getPrice();
        this.description = another.getDescription();
        this.manufactor = another.getManufactor();
    }
}

