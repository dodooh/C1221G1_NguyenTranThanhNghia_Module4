package com.codegym.service;

import com.codegym.model.Product;
import java.util.List;
import java.util.Map;

public interface IProductService {
    List<Product> getListProduct();
    void save(Product product);
    Product findById(int id);
    void update(int id, Product product);
    void remove(int index);

    List<Product> search(String keyword);
}
