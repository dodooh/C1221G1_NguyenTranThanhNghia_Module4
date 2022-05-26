package com.codegym.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CondimentController {

    @GetMapping("/")
    public String goHome() {
        return "index";
    }


    @RequestMapping("/save")
    public String save(@RequestParam(value = "condiment", defaultValue = "") String[] condiment,
        Model model) {
        model.addAttribute("condiments", condiment);
        return "index";
    }
}
