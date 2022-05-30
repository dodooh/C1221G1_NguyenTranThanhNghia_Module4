package com.codegym.furama.service;


import com.codegym.furama.model.user.AppUser;

public interface IUserService {
    boolean isAlreadyExistAccount(String userName);

    void save(AppUser appUser);
}
