package com.codegym.repository;

import com.codegym.model.Declaration;

public interface IDeclarationRepository {
    void save(Declaration declaration);

    Declaration get();
}
