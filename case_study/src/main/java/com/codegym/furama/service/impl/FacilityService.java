package com.codegym.furama.service.impl;

import com.codegym.furama.model.facility.Facility;
import com.codegym.furama.repository.IFacilityRepository;
import com.codegym.furama.service.IFacilityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacilityService implements IFacilityService {

    @Autowired
    private IFacilityRepository facilityRepository;

    @Override
    public List<Facility> findAll() {
        return facilityRepository.findAll();
    }

    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);
    }
}
