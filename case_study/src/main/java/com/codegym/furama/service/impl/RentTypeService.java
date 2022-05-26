package com.codegym.furama.service.impl;

import com.codegym.furama.model.facility.RentType;
import com.codegym.furama.repository.IRentTypeRepository;
import com.codegym.furama.service.IRentTypeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentTypeService implements IRentTypeService {

    @Autowired
    private IRentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }
}
