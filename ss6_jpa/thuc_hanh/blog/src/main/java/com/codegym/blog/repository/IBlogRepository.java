package com.codegym.blog.repository;

import com.codegym.blog.model.Blog;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog, Long> {

    List<Blog> findAll();

}
