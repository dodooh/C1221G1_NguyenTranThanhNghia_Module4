package com.codegym.furama.service.impl;

import com.codegym.furama.model.user.AppUser;
import com.codegym.furama.repository.IAppRoleRepository;
import com.codegym.furama.repository.IAppUserRepository;
import com.codegym.furama.service.IUserService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private IAppUserRepository iAppUserRepository;

    @Autowired
    private IAppRoleRepository iAppRoleRepository;

    @Override
    public boolean isAlreadyExistAccount(String userName) {
        Optional<AppUser> appUser = this.iAppUserRepository.findByUserName(userName);
        return appUser.isPresent();
    }

    @Override
    public void save(AppUser appUser) {
        AppUser appUser1 = iAppUserRepository.save(appUser);
        iAppRoleRepository.setRoleUser(appUser1.getUserId());
    }
}
