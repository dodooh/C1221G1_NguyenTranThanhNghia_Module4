package codegym.danang.demo.service;

import codegym.danang.demo.dto.UserDto;
import codegym.danang.demo.entity.AppUser;
import codegym.danang.demo.exception.UserAlreadyExistException;

public interface IUserService {
    boolean isAlreadyExistAccount(String userName);

    void save(AppUser appUser);
}
