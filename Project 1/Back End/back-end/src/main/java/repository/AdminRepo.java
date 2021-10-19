package repository;

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


    public static Admin getAdminById(int id) {
        //Create session
        Session session = HibernateUtil.getSession();
        //Begin transaction
        Transaction transaction = session.beginTransaction();
        //Get data from database using the admin id
        Admin admin = session.get(Admin.class,id);
        transaction.commit();//Has database update the available column to match the above change
        return admin;
    }

    public static List<Admin> getAllAdmins() {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Admin> query = builder.createQuery(Admin.class);
        Root<Admin> root = query.from(Admin.class);
        query.select(root);
        List<Admin> list = session.createQuery(query).getResultList();

        transaction.commit();//Has database update the available column to match the above change
        return list;
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