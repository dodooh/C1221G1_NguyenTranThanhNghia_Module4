package com.codegym.furama.rest_controller;


import static org.springframework.http.HttpStatus.OK;

import com.codegym.furama.dto.CustomerDto;
import com.codegym.furama.model.Response;
import com.codegym.furama.model.customer.Customer;
import com.codegym.furama.service.ICustomerService;
import com.codegym.furama.service.ICustomerTypeService;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable String id) {
        Optional<Customer> customer = customerService.findById(id);
        if (!customer.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            Map<String, Customer> responseData = new HashMap<String, Customer>() {{
                put("customer", customer.get());
            }};
            return ResponseEntity.ok(Response.builder()
                .timeStamp(LocalDateTime.now())
                .data(responseData)
                .message("Get customer with id: "+ id + " successfully")
                .status(OK)
                .statusCode(OK.value())
                .build());
        }
    }

    @GetMapping("")
    public ResponseEntity<Response> getList(@PageableDefault(size = 4) Pageable pageable) {
        Page<Customer> customerPage = customerService.findAll(pageable);
        Map<String, Page<Customer>> responseData = new HashMap<String, Page<Customer>>() {{
            put("customers", customerPage);
        }};
        return ResponseEntity.ok(Response.builder()
            .timeStamp(LocalDateTime.now())
            .data(responseData)
            .message("get list customer")
            .status(OK)
            .statusCode(OK.value())
            .build());
    }


    @PostMapping("")
    public ResponseEntity<?> doCreate(@Validated @RequestBody CustomerDto customerDto, BindingResult bindingResult) {

        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            Map<String, Object> responseObject = new HashMap<>();
            responseObject.put("errors", bindingResult.getFieldErrors());
            return new ResponseEntity<>(responseObject, HttpStatus.BAD_REQUEST);
        }
        try {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            Customer customerRes = customerService.save(customer);
            Map<String, Object> responseData = new HashMap<String, Object>() {{
                put("customer", customerRes);
            }};

            return ResponseEntity.ok(Response.builder()
                .timeStamp(LocalDateTime.now())
                .data(responseData)
                .message("Create By RestAPI Successfully")
                .status(OK)
                .statusCode(OK.value())
                .build());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("{id}")
    public ResponseEntity<?> doUpdate(@PathVariable String id, @Validated @RequestBody CustomerDto customerDto, BindingResult bindingResult) {

        Optional<Customer> customerOptional = customerService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            Map<String, Object> responseObject = new HashMap<>();
            responseObject.put("errors", bindingResult.getFieldErrors());

            return new ResponseEntity<>(responseObject, HttpStatus.BAD_REQUEST);
        }
        try {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customer.setId(id);
            Customer customerRes = customerService.save(customer);
            Map<String, Object> responseData = new HashMap<>();
            responseData.put("customer", customerRes);

            return ResponseEntity.ok(Response.builder()
                .timeStamp(LocalDateTime.now())
                .data(responseData)
                .message("Update By RestAPI Successfully")
                .status(OK)
                .statusCode(OK.value())
                .build());
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> doDelete(@PathVariable String id) {
        Optional<Customer> customerOptional = customerService.findById(id);
        Map<String, Object> responseObject = new HashMap<>();

        if (!customerOptional.isPresent()) {
            responseObject.put("message", "id not found");
            return new ResponseEntity<>(responseObject, HttpStatus.NOT_FOUND);
        }
        customerService.deactivate(customerOptional.get());
        return ResponseEntity.ok(Response.builder()
            .timeStamp(LocalDateTime.now())
            .message("Delete By RestAPI Successfully")
            .status(OK)
            .statusCode(OK.value())
            .build());
    }
}
