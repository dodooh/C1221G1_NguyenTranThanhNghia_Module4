package com.codegym.repository.impl;

import com.codegym.model.Declaration;
import com.codegym.repository.IDeclarationRepository;
import org.springframework.stereotype.Repository;


@Repository
public class DeclarationRepositoryImpl implements IDeclarationRepository {

    private Declaration userDeclaration = new Declaration();

    @Override
    public void save(Declaration declaration) {
        userDeclaration = new Declaration(declaration);
    }

    @Override
    public Declaration get() {
        return userDeclaration;
    }
}
