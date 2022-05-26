package com.codegym.furama.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class SortUtils {

    public static Pageable sortProcess(Pageable pageable, String sort, String dir) {
        if ("".equals(dir)) {
            return pageable;
        }
        String nextSort = "name";
        if ("name".equals(sort)) {
            nextSort = "dayOfBirth";
        } else if ("dayOfBirth".equals(sort)) {
            nextSort = "mail";
        } else {
            nextSort = "name";
        }

        if ("asc".equals(dir)) {
            return PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(sort).ascending().and(Sort.by(nextSort)));
        }
        return PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(sort).descending().and(Sort.by(nextSort)));

    }
}
