package com.codegym.blog.blog_v2.service.impl;

import com.codegym.blog.blog_v2.model.Category;
import com.codegym.blog.blog_v2.repository.ICategoryRepository;
import com.codegym.blog.blog_v2.service.ICategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public Category save(Category category) {
        return iCategoryRepository.save(category);
    }

    @Override
    public Category findById(Integer id) {
        return iCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Category category) {
        iCategoryRepository.delete(category);
    }
}
