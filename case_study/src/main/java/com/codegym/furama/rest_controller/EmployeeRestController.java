package com.codegym.furama.rest_controller;


import com.codegym.furama.dto.EmployeeDto;
import com.codegym.furama.model.employee.Employee;
import com.codegym.furama.service.IDepartmentService;
import com.codegym.furama.service.IEducationDegreeService;
import com.codegym.furama.service.IEmployeeService;
import com.codegym.furama.service.IPositionService;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/employee")
public class EmployeeRestController {

    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private IPositionService iPositionService;

    @Autowired
    private IEducationDegreeService iEducationDegreeService;

    @Autowired
    private IDepartmentService iDepartmentService;

    @GetMapping(value = {"/{id}"})
    public ResponseEntity<?> getEmployee(@PathVariable String id) {

        Optional<Employee> employeeOptional = iEmployeeService.findById(id);
        if (!employeeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Map<String, Object> responseObject = new HashMap<>();

        responseObject.put("employee", employeeOptional.get());
        responseObject.put("educationDegrees", iEducationDegreeService.findAll());
        responseObject.put("positions", iPositionService.findAll());
        responseObject.put("departments", iDepartmentService.findAll());
        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }

    @PatchMapping(value = "")
    public ResponseEntity<?> updateEmployee(@Validated @RequestBody EmployeeDto employeeDto, BindingResult bindingResult) {

        new EmployeeDto().validate(employeeDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            Map<String, Object> responseObject = new HashMap<>();
            responseObject.put("errors", bindingResult.getFieldErrors());
            return new ResponseEntity<>(responseObject, HttpStatus.BAD_REQUEST);
        }
        System.out.println(employeeDto);
        Optional<Employee> employeeOptional = iEmployeeService.findById(employeeDto.getId());
        if (!employeeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        try {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
//            employee.setId(id);
            System.out.println(employee);
            iEmployeeService.save(employee);
            Map<String, Object> responseObject = new HashMap<>();
            responseObject.put("employee", employee);
            responseObject.put("educationDegrees", iEducationDegreeService.findAll());
            responseObject.put("positions", iPositionService.findAll());
            responseObject.put("departments", iDepartmentService.findAll());
            responseObject.put("message", "Update By RestAPI Successfully");
            return new ResponseEntity<>(responseObject, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
