package com.codegym.furama.repository;

import com.codegym.furama.model.employee.Employee;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;



public interface IEmployeeRepository extends JpaRepository<Employee, String> {

    @Query(value = "select employee_code from m4_furama.employee", nativeQuery = true)
    List<String> findCodeList();

    Page<Employee> findAllByNameContainingAndEmailContainingAndIsActivated(String name, String email,Boolean isActivated, Pageable pageable);

    Page<Employee> findAllByNameContainingAndEmailContainingAndDepartment_IdAndIsActivated(String name, String email, Long id,Boolean isActivated, Pageable pageable);

    List<Employee> findAllByIsActivated(Boolean isActivated);

    @Transactional
    @Modifying
    @Query(value = "update m4_furama.employee e set e.is_activated = false where e.id = :employee_id", nativeQuery = true)
    Integer deactivate(@Param("employee_id") String id);
}
