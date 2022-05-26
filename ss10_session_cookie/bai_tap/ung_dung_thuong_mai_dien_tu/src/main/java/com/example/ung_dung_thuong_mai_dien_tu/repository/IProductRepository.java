package com.example.ung_dung_thuong_mai_dien_tu.repository;

import com.example.ung_dung_thuong_mai_dien_tu.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {

}
