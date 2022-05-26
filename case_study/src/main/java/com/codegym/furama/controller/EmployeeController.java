package com.codegym.furama.controller;


import com.codegym.furama.dto.EmployeeDto;
import com.codegym.furama.model.employee.Employee;
import com.codegym.furama.service.IDepartmentService;
import com.codegym.furama.service.IEducationDegreeService;
import com.codegym.furama.service.IEmployeeService;
import com.codegym.furama.service.IPositionService;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private IPositionService iPositionService;

    @Autowired
    private IEducationDegreeService iEducationDegreeService;

    @Autowired
    private IDepartmentService iDepartmentService;

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("positions", iPositionService.findAll());
        model.addAttribute("educationDegrees", iEducationDegreeService.findAll());
        model.addAttribute("departments", iDepartmentService.findAll());
        model.addAttribute("mainObject", "Employee");
    }

    @GetMapping(value = {"", "list"})
    public String goList(Model model,
        @RequestParam("name") Optional<String> name,
        @RequestParam("email") Optional<String> email,
        @RequestParam("departmentId") Optional<String> departmentId,
        @PageableDefault(value = 5) Pageable pageable) {

        String nameSearch = name.orElse("");
        String emailSearch = email.orElse("");
        String departmentIdSearch = departmentId.orElse("");
        Page<Employee> employeePage = iEmployeeService.findAll(nameSearch, emailSearch, departmentIdSearch ,pageable);
        model.addAttribute("employees", employeePage);
        model.addAttribute("name", nameSearch);
        model.addAttribute("email", emailSearch);
        model.addAttribute("departmentId", departmentIdSearch);

        return "employee/list";
    }

    @GetMapping(value = "create")
    public String goCreate(Model model) {
        model.addAttribute("employeeDto", new EmployeeDto());
        return "employee/create";
    }

    @PostMapping("/delete")
    public String deleteEmployee(@RequestParam("id") String id, RedirectAttributes redirectAttributes) {
        Optional<Employee> employeeOptional = iEmployeeService.findById(id);
        if (!employeeOptional.isPresent()) {
            redirectAttributes.addFlashAttribute("error_message", "Not Found That Employee");
            return "redirect:/employee/list";
        }
        System.out.println(iEmployeeService.deactivate(employeeOptional.get()));
        redirectAttributes.addFlashAttribute("success_message", "Delete Employee Success");
        return "redirect:/employee/list";
    }


    @PostMapping(value = "create")
    public String doCreate(@Validated @ModelAttribute("employeeDto") EmployeeDto employeeDto,
        BindingResult bindingResult,
        RedirectAttributes redirectAttributes) {

        new EmployeeDto().validate(employeeDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {

            return "employee/create";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            employee.setActivated(true);
            iEmployeeService.save(employee);
            redirectAttributes.addFlashAttribute("success_message", "New Employee with Code " + employee.getId() + " has been Add Successfully");
            return "redirect:";
        }
    }


}
