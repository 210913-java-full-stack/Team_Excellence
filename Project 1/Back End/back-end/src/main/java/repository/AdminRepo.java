package repository;

import org.hibernate.Session;
import model.Admin;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class AdminRepo {

    //Gets data from the admin table using the admin id
    public static Admin getAdminById(int id) {
        Session session = HibernateUtil.getSession();
        return session.get(Admin.class,id);
    }
    //Gets data from the admin table using the admin's username
    public static Admin getByUsername(String username) {
        Session session = HibernateUtil.getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Admin> criteria = builder.createQuery(Admin.class);
        Root<Admin> root = criteria.from(Admin.class);
        criteria.select(root).where(builder.equal(root.get("username"), username));
        return session.createQuery(criteria).getSingleResult();
    }

    //Gets all data in the admin table
    public static List<Admin> getAllAdmins() {
        Session session = HibernateUtil.getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Admin> query = builder.createQuery(Admin.class);
        Root<Admin> root = query.from(Admin.class);
        query.select(root);

        return session.createQuery(query).getResultList();
    }

    //Saves admin info to the database
    public static void saveAdmin(Admin admin) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(admin);
        transaction.commit();
    }

    //Deletes a row in the admin table
    public static void deleteAdmin(Admin admin) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(admin);
        transaction.commit();

    }
}