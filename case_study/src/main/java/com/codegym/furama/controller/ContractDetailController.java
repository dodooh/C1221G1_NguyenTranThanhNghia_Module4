package com.codegym.furama.controller;


import com.codegym.furama.dto.ContractDetailDto;
import com.codegym.furama.exception.ObjectNotFoundException;
import com.codegym.furama.model.contract.Contract;
import com.codegym.furama.model.contract.ContractDetail;
import com.codegym.furama.service.IServiceExtraService;
import com.codegym.furama.service.IContractDetailService;
import com.codegym.furama.service.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("detail-contract")
public class ContractDetailController {

    @Autowired
    private IContractDetailService contractDetailService;

    @Autowired
    private IContractService contractService;

    @Autowired
    private IServiceExtraService serviceExtraService;

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("mainObject", "Contract Detail");
        model.addAttribute("serviceExtras", serviceExtraService.findAll());
    }

    @GetMapping("")
    public String goList(@PageableDefault(size = 10) Pageable pageable, Model model) {
        ContractDetailDto cdt = new ContractDetailDto();
        model.addAttribute("contractDetails", contractDetailService.findAll(pageable));
        return "contract_detail/list";
    }

    @PostMapping("create")
    public String doCreate(ContractDetailDto contractDetailDto, RedirectAttributes ra) {
        ContractDetail contractDetail = new ContractDetail();
        BeanUtils.copyProperties(contractDetailDto, contractDetail);
        contractDetailService.save(contractDetail);
        ra.addFlashAttribute("success_message", "Create Successfully");
        return "redirect:";
    }


    @GetMapping("create/{id}")
    public String goCreate(@PathVariable String id, Model model) throws ObjectNotFoundException {
        ContractDetailDto cdt = new ContractDetailDto();
        Contract ct = contractService.findById(id)
            .orElseThrow(ObjectNotFoundException::new);
        cdt.setContract(ct);
        model.addAttribute("contractDetailDto", cdt);
        return "contract_detail/create";
    }

}
