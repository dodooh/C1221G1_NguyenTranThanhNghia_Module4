package com.codegym.furama.controller;


import com.codegym.furama.dto.ContractDto;
import com.codegym.furama.model.contract.Contract;
import com.codegym.furama.service.IContractService;
import com.codegym.furama.service.ICustomerService;
import com.codegym.furama.service.IEmployeeService;
import com.codegym.furama.service.IFacilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("contract")
public class ContractController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IContractService contractService;

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("mainObject", "Contract");
    }

    @GetMapping("")
    public String goList(@PageableDefault(size = 20) Pageable pageable, Model model) {
        model.addAttribute("contracts", contractService.findAll(pageable));
        return "contract/list";
    }

    @GetMapping("create")
    public String goCreate(Model model) {
        model.addAttribute("contractDto", new ContractDto());
        model.addAttribute("customers", customerService.findAll());
        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("facilities", facilityService.findAll());
        return "contract/create";
    }

    @PostMapping("create")
    public String doCreate(ContractDto contractDto ,Model model) {
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);
        contractService.save(contract);
        return "redirect:";
    }


}