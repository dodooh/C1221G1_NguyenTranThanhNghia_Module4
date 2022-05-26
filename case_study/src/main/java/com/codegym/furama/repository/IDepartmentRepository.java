package com.codegym.furama.repository;

import com.codegym.furama.model.employee.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartmentRepository extends JpaRepository<Department, Long> {

}
