package org.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MoneyController {

    @GetMapping("/")
    public String showHome() {
        return "home";
    }

    @GetMapping("/calc")
    public String doCalc(@RequestParam Double usd,
        @RequestParam Integer rate,
        Model model) {
        Double result = usd * rate;
        model.addAttribute("result", result);
        model.addAttribute("usd", usd);
        model.addAttribute("rate", rate);
        return "home";
    }
}
