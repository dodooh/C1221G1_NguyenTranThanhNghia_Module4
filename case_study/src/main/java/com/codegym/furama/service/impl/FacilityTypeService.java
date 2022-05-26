package com.codegym.furama.service.impl;

import com.codegym.furama.model.facility.FacilityType;
import com.codegym.furama.repository.IFacilityTypeRepository;
import com.codegym.furama.service.IFacilityTypeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacilityTypeService implements IFacilityTypeService {

    @Autowired
    private IFacilityTypeRepository facilityTypeRepository;


    @Override
    public List<FacilityType> findAll() {
        return facilityTypeRepository.findAll();
    }
}
