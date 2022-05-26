package com.codegym.furama.service;

import com.codegym.furama.model.facility.RentType;
import java.util.List;

public interface IRentTypeService {

    List<RentType> findAll();
}
