package com.codegym.furama.service.impl;

import com.codegym.furama.model.contract.ServiceExtra;
import com.codegym.furama.repository.IServiceExtraRepository;
import com.codegym.furama.service.IServiceExtraService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ExtraService implements IServiceExtraService {


    @Autowired
    private IServiceExtraRepository attachServiceRepository;

    @Override
    public List<ServiceExtra> findAll() {
        return attachServiceRepository.findAll();
    }
}
