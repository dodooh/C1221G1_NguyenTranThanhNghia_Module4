package com.codegym.furama.repository;

import com.codegym.furama.model.facility.FacilityType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacilityTypeRepository extends JpaRepository<FacilityType, Long> {

}
