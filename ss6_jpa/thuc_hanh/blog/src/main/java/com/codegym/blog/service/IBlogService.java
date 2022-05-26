package com.codegym.blog.service;

import com.codegym.blog.model.Blog;
import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
}
