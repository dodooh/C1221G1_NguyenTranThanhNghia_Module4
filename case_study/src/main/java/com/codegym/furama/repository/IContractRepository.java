package com.codegym.furama.repository;

import com.codegym.furama.model.contract.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractRepository extends JpaRepository<Contract, String> {

}
