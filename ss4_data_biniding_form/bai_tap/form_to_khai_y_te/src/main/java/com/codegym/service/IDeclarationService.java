package com.codegym.service;

import com.codegym.model.Declaration;

public interface IDeclarationService {
    void save(Declaration declaration);

    Declaration get();
}
