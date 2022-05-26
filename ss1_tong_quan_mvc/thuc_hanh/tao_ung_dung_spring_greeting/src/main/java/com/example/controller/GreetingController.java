package com.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @GetMapping("/")
    public String greeting(@RequestParam String name, Model model) {
//        System.out.println(name);
        model.addAttribute("displayName", name);
        return "/greeting";
    }
}
