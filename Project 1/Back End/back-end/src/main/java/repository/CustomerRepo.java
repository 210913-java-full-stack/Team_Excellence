package repository;

import model.Flight;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import model.Customer;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


public class CustomerRepo {

    private static SessionFactory sessionFactory;
    private static Session session;


    public static void init() {

    }

    public static Customer getCustomerById(Integer id) {
        Customer customer = null;
        Transaction t = null;
        Session session = null;
        try{
            CustomerRepo.setSession(CustomerRepo.getSessionFactory().openSession());
            session = CustomerRepo.getSession();
            t = session.beginTransaction();
            customer = session.get(Customer.class, id);
            t.commit();
        }catch(Exception e){
            e.printStackTrace();
            if (t!=null) {
                t.rollback();
            }
        } finally {
            if (session!= null) {
                session.close();
            }
        }



        return customer;
    }

    public static Customer login(String username, String password) {


        Customer user = null;
        Transaction t = null;
        Session session = null;

        try{

            CustomerRepo.setSession(CustomerRepo.getSessionFactory().openSession());
            session = CustomerRepo.getSession();


        user = (Customer) session.createQuery("FROM Customer c WHERE c.username = :userName").setParameter("userName", username).uniqueResult();

        if (user != null && user.getPassword().equals(password)){

            return user;
        }




        } catch (Exception e){

            user = null;
            e.printStackTrace();
        }


        return user;
    }




    public static List<Customer> getAllCustomers() {
        Transaction t = null;
        Session session = null;
        List<Customer> list = null;
        try{
            CustomerRepo.setSession(CustomerRepo.getSessionFactory().openSession());
            session = CustomerRepo.getSession();
            t = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Customer> query = builder.createQuery(Customer.class);
            Root<Customer> root = query.from(Customer.class);
            query.select(root);
            list = session.createQuery(query).getResultList();
            t.commit();


        } catch (Exception e){
            e.printStackTrace();
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

    public static void saveNewCustomer( Customer customer){
        Transaction t = null;
        Session session = null;

        try {
            CustomerRepo.setSession(CustomerRepo.getSessionFactory().openSession());
            session = CustomerRepo.getSession();
            t = session.beginTransaction();

            session.save(customer);
            t.commit();
        } catch(Exception e){
            e.printStackTrace();

            t.rollback();
        }finally {
            session.close();
        }

    }

    public static void deleteCustomer(Customer customer) {
        Transaction t = null;
        Session session = null;
        try {
            CustomerRepo.setSession(CustomerRepo.getSessionFactory().openSession());
            session = CustomerRepo.getSession();
            t = session.beginTransaction();

            session.delete(customer);
            t.commit();

        } catch(Exception e){
            e.printStackTrace();

            t.rollback();
        }finally {
            session.close();
        }

    }


    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void setSessionFactory(SessionFactory sessionFactory) {
        CustomerRepo.sessionFactory = sessionFactory;
    }

    public static Session getSession() {
        return session;
    }

    public static void setSession(Session session) {
        CustomerRepo.session = session;
    }
}
