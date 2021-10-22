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

    //****** session.get does not require starting and committing a transaction *****

    public static Admin getAdminById(int id) {
        Session session = HibernateUtil.getSession();
        //Get data from database using the admin id
        return session.get(Admin.class,id);
    }

    /**
     * This method
     * @param username
     * @return
     */
    public static Admin getByUsername(String username) {
        Session session = HibernateUtil.getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Admin> criteria = builder.createQuery(Admin.class);
        Root<Admin> root = criteria.from(Admin.class);
        criteria.select(root).where(builder.equal(root.get("username"), username));
        return session.createQuery(criteria).getSingleResult();
    }

    public static List<Admin> getAllAdmins() {
        Session session = HibernateUtil.getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Admin> query = builder.createQuery(Admin.class);
        Root<Admin> root = query.from(Admin.class);
        query.select(root);

        return session.createQuery(query).getResultList();
    }

    public static void saveAdmin(Admin admin) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(admin);
        transaction.commit();//Has database update the available column to match the above change
    }

    public static void deleteAdmin(Admin admin) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(admin);
        transaction.commit();//Has database update the available column to match the above change

    }
}