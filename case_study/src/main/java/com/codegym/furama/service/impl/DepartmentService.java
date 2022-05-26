package com.codegym.furama.service.impl;

import com.codegym.furama.model.employee.Department;
import com.codegym.furama.repository.IDepartmentRepository;
import com.codegym.furama.service.IDepartmentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService implements IDepartmentService {

    @Autowired
    private IDepartmentRepository iDepartmentRepository;

    @Override
    public List<Department> findAll() {
        return iDepartmentRepository.findAll();
    }
}
