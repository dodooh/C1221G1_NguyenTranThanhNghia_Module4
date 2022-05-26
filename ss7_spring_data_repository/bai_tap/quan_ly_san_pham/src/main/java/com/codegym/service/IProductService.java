package com.codegym.service;

import com.codegym.model.Product;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> findAll(String q, Pageable pageable);
    List<String> findAllProductCode();
    void save(Product product);
    Product findById(Integer id);
    void remove(Product product);
}
