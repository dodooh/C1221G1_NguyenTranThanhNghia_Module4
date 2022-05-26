package cg.wbd.grandemonstration.servlet;

import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping("/customers")
    public String showList(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "customers/list.jsp";
    }

    @GetMapping("/info")
    public String showInfo(@RequestParam Long id, Model model) {
        Customer customer = customerService.findOne(id);
        model.addAttribute("customer", customer);
        return "customers/info.jsp";
    }
    @PostMapping("/customers")
    public String updateCustomer(@RequestParam String name,
                                @RequestParam String email,
                                @RequestParam String address,
                                @RequestParam Long id,
                                Model model) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setAddress(address);
        customer.setId(id);
        customerService.save(customer);
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "customers/list.jsp";
    }
}
