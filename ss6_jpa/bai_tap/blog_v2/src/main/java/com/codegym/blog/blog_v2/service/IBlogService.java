package com.codegym.blog.blog_v2.service;

import com.codegym.blog.blog_v2.model.Blog;
import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    List<Blog> findAllByTitleContains(String q);

    void save(Blog blog);

    Blog findById(Long id);

    void delete(Blog blog);
}
