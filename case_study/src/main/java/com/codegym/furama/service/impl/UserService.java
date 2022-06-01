package com.codegym.furama.service.impl;

import com.codegym.furama.model.user.AppUser;
import com.codegym.furama.repository.IAppRoleRepository;
import com.codegym.furama.repository.IAppUserRepository;
import com.codegym.furama.service.IUserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
    public boolean save(AppUser appUser) {
        if (isAlreadyExistAccount(appUser.getUserName())) {
            return false;
        }
        AppUser appUser1 = iAppUserRepository.save(appUser);
        iAppRoleRepository.setRoleUser(appUser1.getUserId());
        return true;
    }

    @Override
    public List<AppUser> findAll() {
        return iAppUserRepository.findAll();
    }

    @Override
    public AppUser findById(Long id) {
        return iAppUserRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        iAppUserRepository.deleteById(id);
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return iAppUserRepository.findByUserName(username).orElse(null);
    }

    @Override
    public List<GrantedAuthority> getAuthorities(AppUser user) {
        List<String> roleNames = this.iAppRoleRepository.getRoleNames(user.getUserId());

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (roleNames != null) {
            for (String role : roleNames) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        }
        return grantList;
    }
}
