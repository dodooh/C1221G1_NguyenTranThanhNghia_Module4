package com.codegym.furama.service.impl;

import com.codegym.furama.model.employee.Position;
import com.codegym.furama.repository.IPositionRepository;
import com.codegym.furama.service.IPositionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PositionService implements IPositionService {

    @Autowired
    private IPositionRepository iPositionRepository;


    @Override
    public List<Position> findAll() {
        return iPositionRepository.findAll();
    }
}
