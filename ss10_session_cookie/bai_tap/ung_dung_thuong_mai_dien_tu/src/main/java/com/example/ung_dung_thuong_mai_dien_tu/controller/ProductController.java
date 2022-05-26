package com.example.ung_dung_thuong_mai_dien_tu.controller;

import com.example.ung_dung_thuong_mai_dien_tu.model.Cart;
import com.example.ung_dung_thuong_mai_dien_tu.model.Product;
import com.example.ung_dung_thuong_mai_dien_tu.service.IProductService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", iProductService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }


    @PostMapping("/create")
    public String showCreate(@ModelAttribute("product") Product product, RedirectAttributes ra) {
        iProductService.save(product);
        ra.addFlashAttribute("message", "Create Successful");
        return "redirect:/shop";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id,
        @ModelAttribute Cart cart,
        @RequestParam("action") String action,
        @RequestParam("quantity") Optional<Integer> qtt) {

        Integer quantity = qtt.orElse(1);
        Optional<Product> productOptional = iProductService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional.get(), quantity);
            return "redirect:/cart";
        } else if (action.equals("view")) {
            cart.addProduct(productOptional.get(), quantity);
            return "redirect:/view/" + id;
        }
        cart.addProduct(productOptional.get(), quantity);
        return "redirect:/shop";
    }

    @GetMapping("/remove/{id}")
    public String removeFromCart(@PathVariable Long id, @ModelAttribute Cart cart) {
        Optional<Product> productOptional = iProductService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        cart.remove(productOptional.get());
        return "redirect:/cart";
    }

    @GetMapping("/decrease/{id}")
    public String decreaseProductCart(@PathVariable Long id, @ModelAttribute Cart cart) {
        Optional<Product> productOptional = iProductService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        cart.decrease(productOptional.get());
        return "redirect:/cart";
    }

    @GetMapping("/view/{id}")
    public String viewProductDetail(@PathVariable Long id, Model model) {
        Optional<Product> productOptional = iProductService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        model.addAttribute("product",productOptional.get());
        return "view";
    }


}
