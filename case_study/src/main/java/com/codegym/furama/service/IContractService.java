package com.codegym.furama.service;

import com.codegym.furama.model.contract.Contract;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {

    Page<Contract> findAll(Pageable pageable);

    void save(Contract contract);

    Optional<Contract> findById(String id);
}
