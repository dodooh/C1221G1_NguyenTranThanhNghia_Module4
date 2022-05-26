package com.codegym.blog.blog_v2.service.impl;

import com.codegym.blog.blog_v2.model.Blog;
import com.codegym.blog.blog_v2.repository.IBlogRepository;
import com.codegym.blog.blog_v2.service.IBlogService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public Page<Blog> findAll(String name, Pageable pageable) {
        return iBlogRepository.findAllByTitleContaining(name,pageable);
    }

    @Override
    public List<Blog> findAllByTitleContains(String q) {
        return iBlogRepository.findAllByTitleContains(q);
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public Blog findById(Long id) {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Blog blog) {
        iBlogRepository.delete(blog);
    }
}
