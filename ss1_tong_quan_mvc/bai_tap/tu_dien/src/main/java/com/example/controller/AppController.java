package com.example.controller;

import com.example.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {
    @Autowired
    private IDictionaryService iDictionaryService;

    @GetMapping("/")
    public String showApp() {
        return "app";
    }
    @GetMapping("/translate")
    public String translate(@RequestParam String word, Model model) {

        String result = iDictionaryService.search(word);
        model.addAttribute("result", result);
        return "app";
    }



}
