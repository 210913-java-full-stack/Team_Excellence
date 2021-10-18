package repository;

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
        return session.get(Customer.class, id);
    }

    public static Customer login(String username, String password) {


        Customer user = null;

        try{




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
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Customer> query = builder.createQuery(Customer.class);
        Root<Customer> root = query.from(Customer.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }

    public static void saveNewCustomer( Customer customer){
        try {
            Transaction t = session.beginTransaction();
            System.out.println(t.getStatus());

            session.save(customer);
            t.commit();
        } catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void deleteCustomer(Customer customer) {
        try {
            Transaction t = session.beginTransaction();
            System.out.println(t.getStatus());

            session.delete(customer);
            t.commit();

        } catch(Exception e){
            e.printStackTrace();
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
