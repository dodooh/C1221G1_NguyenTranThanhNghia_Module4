package com.codegym.blog.blog_v2.dto;

import javax.validation.constraints.Pattern;

public class CategoryDto {
    private Integer id;
    @Pattern(regexp = "[A-Za-z ]+", message = "At least 1 character")
    private String categoryName;

    public CategoryDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
