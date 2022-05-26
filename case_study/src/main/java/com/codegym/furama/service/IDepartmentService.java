package com.codegym.furama.service;

import com.codegym.furama.model.employee.Department;
import java.util.List;

public interface IDepartmentService {

    List<Department> findAll();
}
