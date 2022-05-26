package com.codegym.furama.service.impl;

import com.codegym.furama.model.employee.EducationDegree;
import com.codegym.furama.repository.IEducationDegreeRepository;
import com.codegym.furama.service.IEducationDegreeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EducationDegreeService implements IEducationDegreeService {

    @Autowired
    private IEducationDegreeRepository iEducationDegreeRepository;


    @Override
    public List<EducationDegree> findAll() {
        return iEducationDegreeRepository.findAll();
    }
}
