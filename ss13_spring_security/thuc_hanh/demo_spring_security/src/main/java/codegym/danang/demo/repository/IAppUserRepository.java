package codegym.danang.demo.repository;

import codegym.danang.demo.entity.AppUser;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUserName(String username);
}
