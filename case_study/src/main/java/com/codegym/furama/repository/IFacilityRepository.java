package com.codegym.furama.repository;

import com.codegym.furama.model.facility.Facility;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacilityRepository extends JpaRepository<Facility, String> {

}
