package com.codegym.blog.blog_v2.service;

import com.codegym.blog.blog_v2.model.Category;
import java.util.List;

public interface ICategoryService {

    List<Category> findAll();
}
