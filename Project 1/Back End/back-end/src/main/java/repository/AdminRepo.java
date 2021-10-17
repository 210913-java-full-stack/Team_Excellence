package repository;

import org.hibernate.Session;
import model.Admin;
import org.hibernate.SessionFactory;
import utils.HibernateUtil;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class AdminRepo {
    private static HibernateUtil hibernateUtil = new HibernateUtil();
    private static Session session = hibernateUtil.getSession();


    public static Admin getAdminById(int id) {
        return session.get(Admin.class, id);
    }

    public static List<Admin> getAllAdmins() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Admin> query = builder.createQuery(Admin.class);
        Root<Admin> root = query.from(Admin.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }

    public static void saveAdmin(Admin admin){
        session.save(admin);
    }

    public static void deleteAdmin(Admin admin){
        session.delete(admin);
    }

//    public static SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
//
//    public static void setSessionFactory(SessionFactory sessionFactory) {
//        AdminRepo.sessionFactory = sessionFactory;
//    }
//
//    public static Session getSession() {
//        return session;
//    }
//
//    public static void setSession(Session session) {
//        AdminRepo.session = session;
//    }
}