package com.codegym.blog.controller;


import com.codegym.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

    @GetMapping({"","/blogs"})
    public ModelAndView goHomepage(Model model) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("blogs", iBlogService.findAll());
        return modelAndView;
    }


}
