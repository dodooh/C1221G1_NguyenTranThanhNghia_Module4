package com.codegym.furama.controller;


import com.codegym.furama.exception.ObjectNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FuramaController {

    @RequestMapping(value = {"", "home"}, method = RequestMethod.GET)
    public String goHomePage(Model model) {
        return "furama/index";
    }


    @ExceptionHandler(value = ObjectNotFoundException.class)
    public String goError() {
        return "furama/error";
    }
}
