package com.codegym.furama.service;


import com.codegym.furama.model.user.AppUser;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;

public interface IUserService {
    boolean isAlreadyExistAccount(String userName);

    boolean save(AppUser appUser);

    List<AppUser> findAll();

    AppUser findById(Long id);

    void delete(Long id);

    AppUser loadUserByUsername(String username);

    List<GrantedAuthority> getAuthorities(AppUser user);
}
