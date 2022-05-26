package com.codegym.furama.service.impl;

import com.codegym.furama.model.contract.Contract;
import com.codegym.furama.repository.IContractRepository;
import com.codegym.furama.service.IContractService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ContractService implements IContractService {


    @Autowired
    private IContractRepository contractRepository;


    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public Optional<Contract> findById(String id) {
        return contractRepository.findById(id);
    }
}
