package com.example.ung_dung_thuong_mai_dien_tu.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product,Integer> products = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product,Integer> products) {
        this.products = products;
    }

    public Map<Product,Integer> getProducts() {
        return products;
    }

    private boolean checkItemInCart(Product product){
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if(entry.getKey().getCode().equals(product.getCode())){
                return true;
            }
        }
        return false;
    }

    private Map.Entry<Product, Integer> selectItemInCart(Product product){
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if(entry.getKey().getCode().equals(product.getCode())){
                return entry;
            }
        }
        return null;
    }

    public void addProduct(Product product, Integer quantity){
        if (!checkItemInCart(product)){
            products.put(product, quantity);
        } else {
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
            Integer newQuantity = itemEntry.getValue() + quantity;
            products.replace(itemEntry.getKey(),newQuantity);
        }
    }

    public void remove(Product product){
        if (checkItemInCart(product)){
            Product findInCart = this.selectItemInCart(product).getKey();
            products.remove(findInCart);
        }
    }

    public void decrease(Product product){
        if (checkItemInCart(product)){
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
            Integer newQuantity = itemEntry.getValue() - 1;
            if (newQuantity == 0) {
                remove(itemEntry.getKey());
            } else {
                products.replace(itemEntry.getKey(),newQuantity);
            }
        }
    }

    public Integer countProductQuantity(){
        Integer productQuantity = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    public Integer countItemQuantity(){
        return products.size();
    }

    public Float countTotalPayment(){
        float payment = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }
}
