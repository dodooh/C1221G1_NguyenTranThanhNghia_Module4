package com.example.ung_dung_thuong_mai_dien_tu.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Entity
public class Product {

    @Id
    @GenericGenerator(name = "random_4_number_id", strategy = "com.example.ung_dung_thuong_mai_dien_tu.utils.MyGenerator")
    @GeneratedValue(generator = "random_4_number_id")
    private Long code;

    private String name;
    private Long price;
    private Long oldPrice;
    private String image;

    public Product() {
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(Long oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
