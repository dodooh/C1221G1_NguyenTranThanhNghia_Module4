package codegym.danang.demo.repository;

import codegym.danang.demo.entity.AppRole;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface IAppRoleRepository extends JpaRepository<AppRole, Long> {

    @Query(value="select ar.role_name from user_role ur "
        + "inner join app_user au on ur.user_id = au.user_id"
        + " inner join app_role ar on ar.role_id = ur.role_id where ur.user_id = :userId", nativeQuery = true)
    List<String> getRoleNames(@Param("userId") Long userId);

    @Modifying(clearAutomatically = true)
    @Query(value="insert INTO user_role (role_id, user_id) VALUES (2, :userId)", nativeQuery = true)
    void setRoleUser(@Param("userId") Long userId);
}
