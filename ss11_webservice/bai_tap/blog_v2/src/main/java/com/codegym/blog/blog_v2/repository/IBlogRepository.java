package com.codegym.blog.blog_v2.repository;

import com.codegym.blog.blog_v2.model.Blog;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBlogRepository extends JpaRepository<Blog, Long> {

    Page<Blog> findAll(Pageable pageable);

    Optional<Blog> findById(Long id);

    @Query(value = "select * from ss6_blog.blog as p where p.title LIKE CONCAT('%',:q,'%')",nativeQuery = true)
    List<Blog> findAllByTitleContains(@Param("q") String q);

    Page<Blog> findAllByTitleContaining(String name, Pageable pageable);
}
