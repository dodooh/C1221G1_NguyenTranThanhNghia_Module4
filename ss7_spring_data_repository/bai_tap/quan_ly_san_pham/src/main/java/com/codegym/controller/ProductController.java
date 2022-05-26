package com.codegym.controller;

import com.codegym.dto.ProductDto;
import com.codegym.utils.CustomPageable;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService iProductService;



    @GetMapping("")
    public ModelAndView goHome(
        @PageableDefault(value = 3) Pageable pageable,
        @RequestParam("sortBy") Optional<String> sort,
        @RequestParam("dir") Optional<String> direction,
        @RequestParam Optional<String> q,
        Model model)
    {
        String dir = direction.orElse("");
        String sortBy = sort.orElse("");
        pageable = CustomPageable.customPageable(pageable, sortBy, dir);
        String keyword = q.orElse("");
        ModelAndView modelAndView = new ModelAndView("index");
        model.addAttribute("productList", iProductService.findAll(keyword, pageable));
        modelAndView.addObject("q",keyword);
        modelAndView.addObject("sortBy",sortBy);
        modelAndView.addObject("dir",dir);
        return modelAndView;
    }



    @GetMapping("/create")
    public String goCreate(Model model) {
        model.addAttribute("productDto", new ProductDto());
        return "create";
    }

    @PostMapping("/create")
    public String createProduct(@Validated @ModelAttribute ProductDto productDto,
        BindingResult bindingResult,
        RedirectAttributes redirectAttributes) {

        productDto.setProductCodeList(iProductService.findAllProductCode());

        new ProductDto().validate(productDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "create";
        } else {
            Product product = new Product();
            BeanUtils.copyProperties(productDto, product);
            iProductService.save(product);
            redirectAttributes.addFlashAttribute("msg", "Add successfully!");
//        model.addAttribute("product", new Product());
            return "redirect:/product/";
        }

    }

    @GetMapping("/update/{id}")
    public String goUpdate(@PathVariable Integer id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "edit";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable Integer id, @ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        product.setId(id);
        iProductService.save(product);
        redirectAttributes.addFlashAttribute("msg", "Update successfully!");
//        model.addAttribute("product", new Product());
        return "redirect:/product/";
    }
    @GetMapping("/{id}")
    public String goDetail(@PathVariable Integer id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "detail";
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        Product product = iProductService.findById(id);
        iProductService.remove(product);
        redirectAttributes.addFlashAttribute("msg", "Delete successfully!");
//        model.addAttribute("product", new Product());
        return "redirect:/product/";
    }

}
