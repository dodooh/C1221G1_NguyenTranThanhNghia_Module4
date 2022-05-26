package com.codegym.blog.blog_v2.repository;

import com.codegym.blog.blog_v2.model.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findAll();

    Optional<Category> findById(Integer id);
}
