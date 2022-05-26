package com.codegym.service.impl;

import com.codegym.model.Declaration;
import com.codegym.repository.IDeclarationRepository;
import com.codegym.service.IDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeclarationServiceImpl implements IDeclarationService {

    @Autowired
    private IDeclarationRepository iDeclarationRepository;

    @Override
    public void save(Declaration declaration) {
        iDeclarationRepository.save(declaration);
    }

    @Override
    public Declaration get() {
        return iDeclarationRepository.get();
    }
}
