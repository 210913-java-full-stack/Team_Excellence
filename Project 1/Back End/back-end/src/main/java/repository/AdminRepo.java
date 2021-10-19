package repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import model.Admin;
import org.hibernate.Transaction;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class AdminRepo {
    private static SessionFactory sessionFactory;
    private static Session session;


    public static Admin getAdminById(int id) {
        Admin admin = null;
        Transaction t = null;
        Session session = null;
        try{
            AdminRepo.setSession(AdminRepo.getSessionFactory().openSession());
            session = AdminRepo.getSession();
            t = session.beginTransaction();
            admin = session.get(Admin.class,id);
            t.commit();
        }catch(Exception e){
            e.printStackTrace();
            if (t!=null){
                t.rollback();
            }
        } finally {
            if (session!= null) {
                session.close();
            }
        }



        return admin;
    }

    public static List<Admin> getAllAdmins() {

        Transaction t = null;
        Session session = null;
        List<Admin> list = null;
        try{
            AdminRepo.setSession(AdminRepo.getSessionFactory().openSession());
            session = AdminRepo.getSession();
            t = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Admin> query = builder.createQuery(Admin.class);
            Root<Admin> root = query.from(Admin.class);
            query.select(root);
            list = session.createQuery(query).getResultList();
            t.commit();
        } catch (Exception e){
            if (t!=null) {
                t.rollback();
            }
        }finally {
            if (session!= null) {
                session.close();
            }
        }

        return list;
    }

    public static void saveAdmin(Admin admin){
        Transaction t = null;
        Session session = null;
        try{
            AdminRepo.setSession(AdminRepo.getSessionFactory().openSession());
            session = AdminRepo.getSession();
            t = session.beginTransaction();
            session.save(admin);
            t.commit();
        } catch (Exception e){
            if (t!=null) {
                t.rollback();
            }
        }finally {
            if (session!= null) {
                session.close();
            }
        }


    }

    public static void deleteAdmin(Admin admin){
        Transaction t = null;
        Session session = null;
        try{
            AdminRepo.setSession(AdminRepo.getSessionFactory().openSession());
            session = AdminRepo.getSession();
            t = session.beginTransaction();
            session.delete(admin);
            t.commit();
        } catch (Exception e){
            if (t!=null) {
                t.rollback();
            }
        }finally {
            if (session!= null) {
                session.close();
            }
        }

    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void setSessionFactory(SessionFactory sessionFactory) {
        AdminRepo.sessionFactory = sessionFactory;
    }

    public static Session getSession() {
        return session;
    }

    public static void setSession(Session session) {
        AdminRepo.session = session;
    }
}
