package com.codegym.repository;

import com.codegym.model.Product;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IProductRepository extends JpaRepository<Product, Integer> {
//    int getIndexOfProduct(Integer id);
    @Query(value="select product_code from product", nativeQuery = true)
    List<String> findAllProductCode();

    Page<Product> findAllByNameContaining(String name, Pageable pageable);
}
