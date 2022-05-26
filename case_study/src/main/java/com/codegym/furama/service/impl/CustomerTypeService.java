package com.codegym.furama.service.impl;

import com.codegym.furama.model.customer.CustomerType;
import com.codegym.furama.repository.ICustomerTypeRepository;
import com.codegym.furama.service.ICustomerTypeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerTypeService implements ICustomerTypeService {

    @Autowired
    private ICustomerTypeRepository customerTypeRepository;


    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
