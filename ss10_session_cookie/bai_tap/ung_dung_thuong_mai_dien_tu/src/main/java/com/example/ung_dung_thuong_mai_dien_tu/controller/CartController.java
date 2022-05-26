package com.example.ung_dung_thuong_mai_dien_tu.controller;


import com.example.ung_dung_thuong_mai_dien_tu.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartController {

    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping("/cart")
    public ModelAndView showCart (@SessionAttribute(value= "cart", required = false) Cart cart){
        ModelAndView modelAndView = new ModelAndView("/cart");
        modelAndView.addObject("cart",cart);
        return modelAndView;
    }

    @GetMapping("/payment")
    public ModelAndView payment (@SessionAttribute(value= "cart", required = false) Cart cart){
        ModelAndView modelAndView = new ModelAndView("/payment");
        modelAndView.addObject("cart",cart);
        return modelAndView;
    }

}
