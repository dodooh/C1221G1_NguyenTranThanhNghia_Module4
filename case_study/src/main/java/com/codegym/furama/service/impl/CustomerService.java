package com.codegym.furama.service.impl;

import com.codegym.furama.model.customer.Customer;
import com.codegym.furama.repository.ICustomerRepository;
import com.codegym.furama.service.ICustomerService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;


    @Override
    public Page<Customer> findAllByName(String keyword, Pageable pageable) {
        return iCustomerRepository.findAllByNameContainingAndIsActivated(keyword, true, pageable);
    }

    @Override
    public Customer save(Customer customer) {
        return iCustomerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findById(String id) {
        return iCustomerRepository.findByIdAndIsActivated(id, true);
    }

    @Override
    public Integer deactivate(Customer customer) {
        return iCustomerRepository.deactivate(customer.getId());
    }

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
    }
}
