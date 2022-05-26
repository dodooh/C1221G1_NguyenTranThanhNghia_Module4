package com.codegym.controller;


import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @GetMapping("")
    public String goHome(Model model) {
        model.addAttribute("productList", iProductService.getListProduct());
        return "index";
    }

    @GetMapping("/create")
    public String goCreate(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        iProductService.save(product);
        redirectAttributes.addFlashAttribute("msg", "Add successfully!");
//        model.addAttribute("product", new Product());
        return "redirect:/product/";
    }

    @GetMapping("/update/{id}")
    public String goUpdate(@PathVariable Integer id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "edit";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable Integer id, @ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        iProductService.update(id, product);
        redirectAttributes.addFlashAttribute("msg", "Update successfully!");
//        model.addAttribute("product", new Product());
        return "redirect:/product/";
    }
    @GetMapping("/{id}")
    public String goDetail(@PathVariable Integer id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "detail";
    }

    @GetMapping("/search")
    public String searchProduct(@RequestParam String q, Model model) {
        model.addAttribute("productList", iProductService.search(q));
        return "index";
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        iProductService.remove(id);
        redirectAttributes.addFlashAttribute("msg", "Delete successfully!");
//        model.addAttribute("product", new Product());
        return "redirect:/product/";
    }

}
