package com.codegym.furama.service;

import com.codegym.furama.model.contract.ContractDetail;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractDetailService {

    Page<ContractDetail> findAll(Pageable pageable);

    void save(ContractDetail contractDetail);
}
