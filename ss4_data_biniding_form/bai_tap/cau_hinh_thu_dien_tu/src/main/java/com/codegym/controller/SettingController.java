package com.codegym.controller;


import com.codegym.model.Setting;
import com.codegym.service.ISettingService;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SettingController {

    @Autowired
    private ISettingService iSettingService;




    @GetMapping("/")
    public String showHomePage(Model model){
        model.addAttribute("setting", iSettingService.get());
        return "index";
    }
    @GetMapping("/save")
    public String saveSetting(@ModelAttribute Setting setting, RedirectAttributes redirectAttributes) {
        iSettingService.save(setting);
        redirectAttributes.addFlashAttribute("message", "Saving Successfully");
        return "redirect:/";
    }
}
