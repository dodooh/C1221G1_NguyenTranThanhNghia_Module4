package com.codegym.validate_thong_tin_bai_hat.controller;

import com.codegym.validate_thong_tin_bai_hat.dto.SongDto;
import com.codegym.validate_thong_tin_bai_hat.model.Song;
import com.codegym.validate_thong_tin_bai_hat.service.ISongService;
import java.util.Collections;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SongController {

    @Autowired
    private ISongService iSongService;

    @GetMapping("")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("songs", iSongService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("songDto", new SongDto());
        return modelAndView;
    }

    @PostMapping("/create")
    public String checkValidation(
        @Validated @ModelAttribute("songDto") SongDto songDto,
        BindingResult bindingResult,
        RedirectAttributes redirectAttributes) {

//        new SongDto().validate(songDto, bindingResult);
        for(FieldError fieldError : bindingResult.getFieldErrors()) {
            System.out.println("field error "+fieldError.getField());
        }
        if (bindingResult.hasFieldErrors()) {
            return "/create";
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto, song);
            iSongService.save(song);
            redirectAttributes.addFlashAttribute("message", "Add successfully");
            return "redirect:";
        }
    }

}
