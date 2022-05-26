package com.codegym.blog.blog_v2.controller;


import com.codegym.blog.blog_v2.model.Blog;
import com.codegym.blog.blog_v2.service.IBlogService;
import com.codegym.blog.blog_v2.service.ICategoryService;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {

    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping({"","/blogs"})
    public ModelAndView goHomepage(Model model) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("blogs", iBlogService.findAll());
        return modelAndView;
    }


    @GetMapping("/create")
    public ModelAndView goCreate(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("categories", iCategoryService.findAll());
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }
    @PostMapping("/create")
    public String createBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        blog.setCreateDate(LocalDate.now());
        blog.setRate(0);
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Create successfully!");
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public ModelAndView goUpdate(@PathVariable("id") Long id){
        iBlogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("update");
        modelAndView.addObject("categories", iCategoryService.findAll());
        modelAndView.addObject("blog", iBlogService.findById(id));
        return modelAndView;
    }

    @GetMapping("/search")
    public ModelAndView searchBlog(@RequestParam String q){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("blogs", iBlogService.findAllByTitleContains(q));
        return modelAndView;
    }

    @PostMapping("/update")
    public String updateBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Update successfully!");
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteBlog(@RequestParam Long id, RedirectAttributes redirectAttributes){
        Blog blog = iBlogService.findById(id);
        iBlogService.delete(blog);
        redirectAttributes.addFlashAttribute("message", "Delete successfully!");
        return "redirect:/";
    }


}
