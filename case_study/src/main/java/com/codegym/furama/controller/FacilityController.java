package com.codegym.furama.controller;


import com.codegym.furama.dto.FacilityDto;
import com.codegym.furama.model.facility.Facility;
import com.codegym.furama.service.IFacilityService;
import com.codegym.furama.service.IFacilityTypeService;
import com.codegym.furama.service.IRentTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("facility")
public class FacilityController {

    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IFacilityTypeService facilityTypeService;

    @Autowired
    private IRentTypeService rentTypeService;

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("facilityTypes", facilityTypeService.findAll());
        model.addAttribute("rentTypes", rentTypeService.findAll());
        model.addAttribute("mainObject", "Facility");
    }

    @GetMapping("")
    public String goList(Model model) {
        model.addAttribute("facilities", facilityService.findAll());
        return "facility/list";
    }

    @GetMapping("create")
    public String goCreate(Model model) {
        model.addAttribute("facilityDto", new FacilityDto());
        return "facility/create";
    }

    @PostMapping("create")
    public String doCreate(@Validated @ModelAttribute FacilityDto facilityDto, BindingResult bindingResult, Model model, RedirectAttributes ra) {
        new FacilityDto().validate(facilityDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("error_message", "Error");
            return "facility/create";
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto, facility);
        facilityService.save(facility);
        ra.addFlashAttribute("ok_message", "New Facility with Code " + facility.getId() + " has been Add Successfully");
        return "redirect:";
    }


}
