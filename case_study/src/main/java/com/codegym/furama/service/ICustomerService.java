package com.codegym.furama.service;

import com.codegym.furama.model.customer.Customer;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {

    Page<Customer> findAllByName(String keyword, Pageable pageable);

    Customer save(Customer customer);

    Optional<Customer> findById(String id);

    Integer deactivate(Customer customer);

    List<Customer> findAll();

    Page<Customer> findAll(Pageable pageable);
}
