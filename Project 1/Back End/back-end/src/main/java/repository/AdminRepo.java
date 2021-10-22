package repository;

import model.Customer;
import org.hibernate.Session;
import model.Admin;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtil;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class AdminRepo {
    private static Session session = HibernateUtil.getSession();
    private static Transaction transaction;

    //****** session.get does not require starting and committing a transaction *****

    public static Admin getAdminById(int id) {
        //Get data from database using the admin id
        return session.get(Admin.class,id);
    }

    /**
     * This method
     * @param username
     * @return
     */
    public static Admin getByUsername(String username) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Admin> criteria = builder.createQuery(Admin.class);
        Root<Admin> root = criteria.from(Admin.class);
        criteria.select(root).where(builder.equal(root.get("username"), username));
        return session.createQuery(criteria).getSingleResult();
    }

    public static List<Admin> getAllAdmins() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Admin> query = builder.createQuery(Admin.class);
        Root<Admin> root = query.from(Admin.class);
        query.select(root);

        return session.createQuery(query).getResultList();
    }

    public static void saveAdmin(Admin admin) {
        transaction = session.beginTransaction();
        session.save(admin);
        transaction.commit();//Has database update the available column to match the above change

    }

    public static void deleteAdmin(Admin admin) {
        transaction = session.beginTransaction();
        session.delete(admin);
        transaction.commit();//Has database update the available column to match the above change

    }
}