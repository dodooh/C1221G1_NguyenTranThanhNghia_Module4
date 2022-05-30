package com.codegym.furama.service.impl;

import com.codegym.furama.model.user.AppUser;
import com.codegym.furama.repository.IAppRoleRepository;
import com.codegym.furama.repository.IAppUserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IAppUserRepository iAppUserRepository;

    @Autowired
    private IAppRoleRepository iAppRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<AppUser> appUser = this.iAppUserRepository.findByUserName(userName);

        if (!appUser.isPresent()) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }

        AppUser appUser1 = appUser.get();
        System.out.println("Found User: " + appUser1);
        // [ROLE_USER, ROLE_ADMIN,..]
        List<String> roleNames = this.iAppRoleRepository.getRoleNames(appUser1.getUserId());

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (roleNames != null) {
            for (String role : roleNames) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        }

        UserDetails userDetails = (UserDetails) new User(appUser1.getUserName(), //
            appUser1.getEncrytedPassword(), grantList);

        return userDetails;
    }

}
