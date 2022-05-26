//package codegym.danang.demo.dao;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.Query;
//
//
//import codegym.danang.demo.entity.UserRole;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//@Repository
//@Transactional
//public class AppRoleDAO {
//
//    @Autowired
//    private EntityManager entityManager;
//
//    public List<String> getRoleNames(Long userId) {
//        String sql = "Select ur.appRole.roleName from " + UserRole.class.getName() + " ur " //
//                + " where ur.appUser.userId = :userId ";
//
//        Query query = this.entityManager.createQuery(sql, String.class);
//        query.setParameter("userId", userId);
//        return query.getResultList();
//    }
//
//    public void setRoleUser(Long userId) {
//        try {
//
//            Query query = entityManager.createNativeQuery("INSERT INTO user_role (role_id, user_id) VALUES (?, ?)");
//            query.setParameter(1, 2);
//            query.setParameter(2, userId);
//            query.executeUpdate();
//        } catch (IllegalStateException  e) {
//            e.printStackTrace();
//        }
//    }
//
//}
