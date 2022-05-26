package com.codegym.furama.service;

import com.codegym.furama.model.contract.ServiceExtra;
import com.codegym.furama.service.impl.ExtraService;
import java.util.List;

public interface IServiceExtraService {

    List<ServiceExtra> findAll();
}
