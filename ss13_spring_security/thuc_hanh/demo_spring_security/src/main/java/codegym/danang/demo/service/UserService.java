package codegym.danang.demo.service;

import codegym.danang.demo.dao.AppRoleDAO;
import codegym.danang.demo.dao.AppUserDAO;
import codegym.danang.demo.entity.AppUser;
import codegym.danang.demo.repository.IAppRoleRepository;
import codegym.danang.demo.repository.IAppUserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

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
