package com.codegym.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class CustomPageable {

    public static Pageable customPageable(Pageable pageable,String sortBy, String dir) {
        if ("".equals(dir)) {
            return pageable;
        }
        String nextSort = "manufacture";
        if ("price".equals(sortBy)) {
            nextSort = "name";
        } else if ("name".equals(sortBy)) {
            nextSort = "price";
        }

        if ("asc".equals(dir)) {
            return PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(sortBy).ascending().and(Sort.by(nextSort)));
        }
        return PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(sortBy).descending().and(Sort.by(nextSort)));
    }

}
