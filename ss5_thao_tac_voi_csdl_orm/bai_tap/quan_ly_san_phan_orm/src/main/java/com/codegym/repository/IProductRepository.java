package com.codegym.repository;

import com.codegym.model.Product;
import java.util.List;

public interface IProductRepository extends ICrudRepository<Product>{
//    int getIndexOfProduct(Integer id);

    Product findById(Integer id);

    List<Product> search(String keyword);
}
