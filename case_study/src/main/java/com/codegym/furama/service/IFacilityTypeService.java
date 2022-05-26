package com.codegym.furama.service;

import com.codegym.furama.model.facility.Facility;
import com.codegym.furama.model.facility.FacilityType;
import java.util.List;

public interface IFacilityTypeService {

    List<FacilityType> findAll();
}
