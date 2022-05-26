package com.codegym.furama.service;

import com.codegym.furama.model.customer.CustomerType;
import java.util.List;

public interface ICustomerTypeService {

    List<CustomerType> findAll();
}
