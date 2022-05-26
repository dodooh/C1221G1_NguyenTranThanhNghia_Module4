package com.codegym.repository.impl;

import static java.util.stream.Collectors.toList;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import org.springframework.stereotype.Repository;


@Repository
public class ProductRepositoryImpl implements IProductRepository {

    private static final List<Product> productList = new ArrayList<>();
    static {
        productList.add(new Product(1,"Iphone X", 1299.9, "Hang nay con nhieu", "Apple"));
        productList.add(new Product(2,"Iphone 11", 1239.9, "Hang nay con nhieu", "Apple"));
        productList.add(new Product(3,"Iphone 12", 1349.9, "Hang nay con nhieu", "Apple"));
        productList.add(new Product(4,"Iphone 13", 1459.9, "Hang nay con nhieu", "Apple"));
        productList.add(new Product(5,"Iphone 14", 1679.9, "Hang nay con nhieu", "Apple"));
        productList.add(new Product(6,"Iphone 15", 1969.9, "Hang nay con it", "Samsung"));
    }

    @Override
    public List<Product> getList() {
        return productList.stream().map(Product::new).collect(toList());
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public void update(int index, Product newProduct) {
        productList.set(index, newProduct);
    }

    @Override
    public void remove(int index) {
        productList.remove(index);
    }

    @Override
    public int getIndexOfProduct(int id) {
        return IntStream.range(0, productList.size())
            .filter(i -> productList.get(i).getId() == id)
            .findFirst().orElse(-1);
    }

    @Override
    public Product findById(int id) {
        return productList.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Product> search(String keyword) {
        return productList.stream().filter(c -> c.getName().toLowerCase().contains(keyword.toLowerCase())).collect(toList());
    }
}
