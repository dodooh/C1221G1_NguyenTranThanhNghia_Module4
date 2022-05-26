package com.codegym.service.impl;

import static java.util.stream.Collectors.toList;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.service.IProductService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImp implements IProductService {

    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Product> getListProduct() {
        return iProductRepository.getList();
    }

    private Map<String, String> validate(Product product) {
        Map<String, String> errorMap = new HashMap<>();
        if (product.getName().length() <= 4) {
            errorMap.put("name", "Name must be > 4 characters length.");
        }
        if (product.getPrice() == null) {
            errorMap.put("price", "Price can't be empty");
        } else if (product.getPrice() <= 0) {
            errorMap.put("price", "Price must be > 0.");
        }
        if (product.getManufactor().length() == 0) {
            errorMap.put("manufacture", "Manufacture must not be empty");
        }
        return errorMap;
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void update(int id, Product product) {
        int indexToEdit = iProductRepository.getIndexOfProduct(id);
        iProductRepository.update(indexToEdit, product);
    }

    @Override
    public void remove(int id) {
        int index = iProductRepository.getIndexOfProduct(id);
        iProductRepository.remove(index);
    }

    @Override
    public List<Product> search(String keyword) {
        return iProductRepository.search(keyword);
    }
}

