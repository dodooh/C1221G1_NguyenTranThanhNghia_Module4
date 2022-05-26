package com.codegym.repository;

import com.codegym.model.Product;
import java.util.List;

public interface ICrudRepository<E> {
    List<E> getList();
    void save(E e);
    void update(int old, Product product);
    void remove(int index);
}
