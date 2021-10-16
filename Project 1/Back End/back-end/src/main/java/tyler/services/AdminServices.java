package tyler.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import model.Admin;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.sql.SQLException;
import java.util.List;

public class AdminServices {
    private static SessionFactory sessionFactory;
    private static Session session;


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

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void setSessionFactory(SessionFactory sessionFactory) {
        AdminServices.sessionFactory = sessionFactory;
    }

    public static Session getSession() {
        return session;
    }

    public static void setSession(Session session) {
        AdminServices.session = session;
    }
}
