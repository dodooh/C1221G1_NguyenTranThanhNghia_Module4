package com.codegym.controller;


import com.codegym.dto.OrderDetailDto;
import com.codegym.model.OrderDetail;
import com.codegym.service.IOrderDetailService;
import com.codegym.service.IProductService;
import com.codegym.service.IProductTypeService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {


    @Autowired
    private IOrderDetailService orderDetailService;

    @Autowired
    private IProductTypeService productTypeService;

    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String goHome(
        @RequestParam("from") Optional<String> from,
        @RequestParam("to") Optional<String> to,
        @PageableDefault(size = 5) Pageable pageable,
        RedirectAttributes redirectAttributes,
        Model model) {
        String fromDate = from.orElse("");
        String toDate = to.orElse("");
        boolean flag = orderDetailService.isValidDate(fromDate, toDate);
        if (!flag) {
            redirectAttributes.addFlashAttribute("error_message", "Date Time Wrong");
            return "redirect:/";
        }
        model.addAttribute("orders", orderDetailService.findAll(fromDate,toDate,pageable) );
        model.addAttribute("from", fromDate);
        model.addAttribute("to", toDate);
        return "index";
    }

    @GetMapping("top")
    public String getTop(
        @RequestParam("limit") Integer limit,
        Model model) {
        model.addAttribute("orders",orderDetailService.findTop(limit) );
        return "top";
    }


    @GetMapping("/create")
    public String goCreate() {
        return "create";
    }

    @GetMapping("/edit/{id}")
    public String goEdit(@PathVariable("id") Long id,Model model) {
        Optional<OrderDetail> optional = orderDetailService.findById(id);
        if (!optional.isPresent()) {
            return "redirect:/";
        }
        OrderDetail orderDetail = optional.get();
        OrderDetailDto orderDetailDto = new OrderDetailDto();
        BeanUtils.copyProperties(orderDetail, orderDetailDto);

        model.addAttribute("orderDetailDto", orderDetailDto);
        model.addAttribute("productTypes", productTypeService.findAll());
        model.addAttribute("products", productService.findAll());
        return "edit";
    }

    @PostMapping("/edit")
    public String doEdit(@Validated @ModelAttribute OrderDetailDto orderDetailDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        new OrderDetailDto().validate(orderDetailDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("productTypes", productTypeService.findAll());
            model.addAttribute("products", productService.findAll());
            return "edit";
        }
        OrderDetail orderDetail = new OrderDetail();
        BeanUtils.copyProperties(orderDetailDto, orderDetail);
        orderDetailService.save(orderDetail);
        redirectAttributes.addFlashAttribute("ok_message", "Edit Successfully");
        return "redirect:/";
    }



}
