package com.codegym.service;

import com.codegym.model.Product;
import java.util.List;

public interface IProductService {
    List<Product> getListProduct();
    void save(Product product);
    Product findById(Integer id);
    void remove(Product product);
    List<Product> search(String keyword);
}
