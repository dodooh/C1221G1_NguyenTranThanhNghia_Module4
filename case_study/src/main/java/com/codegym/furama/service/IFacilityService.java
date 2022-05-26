package com.codegym.furama.service;


import com.codegym.furama.model.facility.Facility;
import java.util.List;

public interface IFacilityService {

    List<Facility> findAll();

    void save(Facility facility);
}
