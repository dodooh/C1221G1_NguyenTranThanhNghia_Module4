package com.example.ung_dung_thuong_mai_dien_tu.service;

import com.example.ung_dung_thuong_mai_dien_tu.model.Product;
import java.util.List;
import java.util.Optional;

public interface IProductService {

    List<Product> findAll();

    void save(Product product);

    Optional<Product> findById(Long id);
}
