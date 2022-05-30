package com.codegym.furama.controller;


import com.codegym.furama.dto.CustomerDto;
import com.codegym.furama.model.customer.Customer;
import com.codegym.furama.model.customer.CustomerType;
import com.codegym.furama.service.ICustomerService;
import com.codegym.furama.service.ICustomerTypeService;
import com.codegym.furama.utils.SortUtils;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @ModelAttribute
    public void addAttributes(Model model) {
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        model.addAttribute("customerTypes", customerTypeList);
        model.addAttribute("mainObject", "Customer");
    }

    @GetMapping(value = {"", "list"})
    public String goList(Model model, @RequestParam("sort") Optional<String> sortBy, @RequestParam("dir") Optional<String> direction,
        @PageableDefault(size = 5) Pageable pageable)
    {

        String sort = sortBy.orElse("");
        String dir = direction.orElse("");
        pageable = SortUtils.sortProcess(pageable, sort, dir);
        Page<Customer> customerPage = customerService.findAll(pageable);
        model.addAttribute("customers", customerPage);
        model.addAttribute("sort", sort);
        model.addAttribute("dir", dir);

        return "customer/list";
    }

    @GetMapping(value = "create")
    public String goCreate(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        return "customer/create";
    }

    @GetMapping(value = "update/{id}")
    public String goUpdate(@PathVariable("id") String id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Customer> customer = customerService.findById(id);

        if (!customer.isPresent()) {
            redirectAttributes.addFlashAttribute("error", "not found");
            return "redirect:";
        }
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer.get(), customerDto);
//        customerDto.setDayOfBirth(DateConverter.fromDBToForm(customerDto.getDayOfBirth()));
        model.addAttribute("customerDto", customerDto);
        return "customer/update";
    }

    @PostMapping(value = "update")
    public String doUpdate(@Validated @ModelAttribute("customerDto") CustomerDto customerDto, BindingResult bindingResult,
        RedirectAttributes redirectAttributes)
    {

        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            redirectAttributes.addFlashAttribute("error_message", "Error");
            return "customer/update";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("success_message", "Update Successfully");
        return "redirect:/customer/update/" + customerDto.getId();
    }

    @PostMapping(value = "create")
    public String doCreate(@Validated @ModelAttribute("customerDto") CustomerDto customerDto, BindingResult bindingResult, Model model,
        RedirectAttributes redirectAttributes)
    {

        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("error_message", "Error");
            return "customer/create";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("success_message", "New Employee with Code " + customer.getId() + " has been Add Successfully");
        return "redirect:";
    }


    @PostMapping("/delete")
    public String doDelete(@RequestParam("id") String id, RedirectAttributes redirectAttributes) {
        Optional<Customer> customerOptional = customerService.findById(id);
        if (!customerOptional.isPresent()) {
            redirectAttributes.addFlashAttribute("error_message", "Not Found That Employee");
            return "redirect:/customer/list";
        }
        System.out.println(customerService.deactivate(customerOptional.get()));
        redirectAttributes.addFlashAttribute("success_message", "Delete Employee Success");
        return "redirect:/customer/list";
    }

}
