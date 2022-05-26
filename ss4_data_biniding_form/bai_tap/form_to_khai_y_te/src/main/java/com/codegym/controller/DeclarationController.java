package com.codegym.controller;


import com.codegym.model.Declaration;
import com.codegym.service.IDeclarationService;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DeclarationController {

    @Autowired
    private IDeclarationService iDeclarationService;

    protected Map<String, Object> referenceData()   {
        Integer MAX_DAY = 31;
        Integer MAX_MONTH = 12;
        Integer MIN_YEAR = 1990;
        Integer MAX_YEAR = 2022;
        Map<String, Object> referenceData = new HashMap<>();

        Map<Integer,Integer> dayList = new LinkedHashMap<>();
        for(int i = 1; i <= MAX_DAY; i++) {
            dayList.put(i,i);
        }
        referenceData.put("dayList", dayList);

        Map<Integer,Integer> monthList = new LinkedHashMap<>();
        for(int i = 1; i <= MAX_MONTH; i++) {
            monthList.put(i,i);
        }
        referenceData.put("monthList", monthList);

        Map<Integer,Integer> yearList = new LinkedHashMap<>();
        for(int i = MIN_YEAR; i <= MAX_YEAR; i++) {
            yearList.put(i,i);
        }
        referenceData.put("yearList", yearList);

        Map<String,String> countryList = new LinkedHashMap<String,String>();
        countryList.put("VN", "Vietnam");
        countryList.put("LA", "Laos");
        countryList.put("Thailand", "Thailand");
        countryList.put("US", "US");
        referenceData.put("countryList", countryList);

        Map<String,String> transportList = new LinkedHashMap<String,String>();
        transportList.put("tauBay", "Tau Bay");
        transportList.put("tauThuyen", "Tau Thuyen");
        transportList.put("oto", "Oto");
        transportList.put("khac", "Khac");
        referenceData.put("transportList", transportList);

        return referenceData;
    }

    @GetMapping("/")
    public String showDeclaration(Model model){
        model.addAttribute("declaration", this.iDeclarationService.get());
        return "view";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("declaration", this.iDeclarationService.get());
        model.addAttribute("referenceData", this.referenceData());
        return "create";
    }
    @PostMapping("/save")
    public String saveSetting(@ModelAttribute Declaration declaration, RedirectAttributes redirectAttributes) {
        this.iDeclarationService.save(declaration);
        redirectAttributes.addFlashAttribute("message", "Saving Successfully");
        return "redirect:/";
    }
}
