package com.codegym.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Double price;
    private String description;
    private String manufacture;
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

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public Product(Integer id, String name, Double price, String description, String manufacture) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.manufacture = manufacture;
        lastProductId++;
    }public Product(String name, Double price, String description, String manufacture) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.manufacture = manufacture;
        lastProductId++;
    }

    public Product(Product another) {
        this.id = another.getId();
        this.name = another.getName();
        this.price = another.getPrice();
        this.description = another.getDescription();
        this.manufacture = another.getManufacture();
    }
}

