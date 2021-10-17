package repository;

import org.hibernate.Session;
import model.Customer;
import org.hibernate.SessionFactory;
import servlets.DependencyLoaderListener;
import utils.HibernateUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


public class CustomerRepo {
    private static HibernateUtil hibernateUtil = new HibernateUtil();
    private static Session session = hibernateUtil.getSession();


    public static void init() {

    }

    public static Customer getCustomerById(Integer id) {
        return session.get(Customer.class, id);
    }


    public static List<Customer> getAllCustomers() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Customer> query = builder.createQuery(Customer.class);
        Root<Customer> root = query.from(Customer.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }

    public static void saveNewCustomer( Customer customer){
        session.save(customer);
    }

    public static void deleteCustomer(Customer customer) {
        session.delete(customer);
    }


//    public static SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
//
//    public static void setSessionFactory(SessionFactory sessionFactory) {
//        CustomerRepo.sessionFactory = sessionFactory;
//    }
//
//    public static Session getSession() {
//        if(session == null){
//            session = sessionFactory.openSession();
//        }
//        return session;
//    }
//
//    public static void setSession(Session session) {
//        CustomerRepo.session = session;
//    }
}