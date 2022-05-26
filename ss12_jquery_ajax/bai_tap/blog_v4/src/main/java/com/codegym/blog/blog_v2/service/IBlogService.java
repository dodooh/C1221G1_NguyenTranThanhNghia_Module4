package com.codegym.blog.blog_v2.service;

import com.codegym.blog.blog_v2.model.Blog;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {
    Page<Blog> findAll(String name,Pageable pageable);
    Page<Blog> findAll(Pageable pageable);

    void save(Blog blog);

    Blog findById(Long id);

    void delete(Blog blog);

}
