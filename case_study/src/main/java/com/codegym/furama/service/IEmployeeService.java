package com.codegym.furama.service;

import com.codegym.furama.model.employee.Employee;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {

    List<Employee> findAll();
    Page<Employee> findAll(Pageable pageable);

    void save(Employee employee);

    Optional<Employee> findById(String id);

    Page<Employee> findAll(String nameSearch, String emailSearch, String departmentIdSearch, Pageable pageable);

    Integer deactivate(Employee employee);
}
