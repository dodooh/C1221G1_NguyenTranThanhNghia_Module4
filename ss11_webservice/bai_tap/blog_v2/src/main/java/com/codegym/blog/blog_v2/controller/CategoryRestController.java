package com.codegym.blog.blog_v2.controller;


import com.codegym.blog.blog_v2.model.Blog;
import com.codegym.blog.blog_v2.model.Category;
import com.codegym.blog.blog_v2.service.ICategoryService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/api/categories")
@RestController
public class CategoryRestController {

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public ResponseEntity<List<Category>> getListCategory() {
        return new ResponseEntity<>(iCategoryService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> saveCategory(@Validated @RequestBody Category category,
        BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.CREATED);
        }
        Map<String, Object> result = new HashMap<>();
        Category newCategory = iCategoryService.save(category);
        result.put("category", newCategory);
        result.put("message", "Create Successfully");
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

}
