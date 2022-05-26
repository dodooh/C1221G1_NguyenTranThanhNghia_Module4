//package codegym.danang.demo.dao;
//
//import javax.persistence.EntityManager;
//import javax.persistence.NoResultException;
//import javax.persistence.Query;
//
//import codegym.danang.demo.entity.AppUser;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//@Repository
//@Transactional
//public class AppUserDAO {
//
//    @Autowired
//    private EntityManager entityManager;
//
//    public AppUser findUserAccount(String userName) {
//        try {
//            String sql = "Select e from " + AppUser.class.getName() + " e " //
//                    + " Where e.userName = :userName ";
//
//            Query query = entityManager.createQuery(sql, AppUser.class);
//            query.setParameter("userName", userName);
//
//            return (AppUser) query.getSingleResult();
//        } catch (NoResultException e) {
//            return null;
//        }
//    }
//
//    public void save(AppUser appUser) {
//        try {
////            String sql = "Insert into " + AppUser.class.getName() + " (enabled, encrypted_password, user_name) " //
////                + " values (:enabled, :encrypted_password, :user_name ) ";
//
//            Query query = entityManager.createNativeQuery("INSERT INTO app_user (enabled, encryted_password, user_name) VALUES (?, ?, ?)");
//            query.setParameter(1, appUser.isEnabled());
//            query.setParameter(2, appUser.getEncrytedPassword());
//            query.setParameter(3, appUser.getUserName());
//            System.out.println(query);
//            query.executeUpdate();
//        } catch (IllegalStateException  e) {
//            e.printStackTrace();
//        }
//    }
//
//}
