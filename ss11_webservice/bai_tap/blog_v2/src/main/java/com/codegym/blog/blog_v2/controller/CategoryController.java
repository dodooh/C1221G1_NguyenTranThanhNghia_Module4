package com.codegym.blog.blog_v2.controller;


import com.codegym.blog.blog_v2.model.Blog;
import com.codegym.blog.blog_v2.model.Category;
import com.codegym.blog.blog_v2.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public ModelAndView goListCategory() {
        ModelAndView modelAndView = new ModelAndView("/category/index");
        modelAndView.addObject("categories", iCategoryService.findAll());
        return modelAndView;
    }

    @GetMapping("create")
    public ModelAndView goCreateCategory() {
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("category",new Category());
        return modelAndView;
    }

    @PostMapping("create")
    public ModelAndView createCategory(@ModelAttribute Category category) {
        iCategoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("message","Add Successfully");
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public ModelAndView goUpdate(@PathVariable("id") Integer id){
        ModelAndView modelAndView = new ModelAndView("/category/update");
        modelAndView.addObject("category", iCategoryService.findById(id));
        return modelAndView;
    }

    @PostMapping("/update")
    public String updateBlog(@ModelAttribute Category category, RedirectAttributes redirectAttributes){
        iCategoryService.save(category);
        redirectAttributes.addFlashAttribute("message", "Update successfully!");
        return "redirect:/category";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView goDelete(@PathVariable("id") Integer id){
        ModelAndView modelAndView = new ModelAndView("/category/delete");
        modelAndView.addObject("category", iCategoryService.findById(id));
        return modelAndView;
    }

    @PostMapping("/delete")
    public String deleteCategory(@ModelAttribute Category category, RedirectAttributes redirectAttributes){
        iCategoryService.delete(category);
        redirectAttributes.addFlashAttribute("message", "Delete successfully!");
        return "redirect:/category";
    }
}
