package com.codegym.furama.service.impl;

import com.codegym.furama.model.employee.Employee;
import com.codegym.furama.repository.IEmployeeRepository;
import com.codegym.furama.service.IEmployeeService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService  implements IEmployeeService {


    @Autowired
    private IEmployeeRepository iEmployeeRepository;


    @Override
    public List<Employee> findAll() {
        return iEmployeeRepository.findAllByIsActivated(true);
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return iEmployeeRepository.findAll(pageable);
    }

    @Override
    public void save(Employee employee) {
        iEmployeeRepository.save(employee);
    }



    @Override
    public Optional<Employee> findById(String id) {
        return iEmployeeRepository.findById(id);
    }


    @Override
    public Page<Employee> findAll(String nameSearch, String emailSearch, String departmentIdSearch, Pageable pageable) {
        if ("".equals(departmentIdSearch)) {
            return iEmployeeRepository.findAllByNameContainingAndEmailContainingAndIsActivated(nameSearch, emailSearch, true, pageable);
        }
        return iEmployeeRepository.findAllByNameContainingAndEmailContainingAndDepartment_IdAndIsActivated(nameSearch, emailSearch, Long.parseLong(departmentIdSearch),true, pageable);
    }

    @Override
    public Integer deactivate(Employee employee) {
        return iEmployeeRepository.deactivate(employee.getId());
    }
}
