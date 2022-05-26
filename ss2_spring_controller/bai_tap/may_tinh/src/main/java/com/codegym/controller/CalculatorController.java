package com.codegym.controller;


import com.codegym.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired
    private ICalculatorService iCalculatorService;

    @GetMapping("/")
    public String goHome() {
        return "index";
    }

    @PostMapping("/calc")
    public String doCalc(
        @RequestParam Double number1,
        @RequestParam Double number2,
        @RequestParam String operator,
        Model model
    ) {
        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);
        model.addAttribute("operator", operator);
        try {
            Double result = this.iCalculatorService.calc(number1, number2, operator);
            model.addAttribute("result", result);
        } catch (ArithmeticException e) {
            model.addAttribute("error", e.getMessage());
        }
        return "index";
    }
}
