package tyler.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import model.Customer;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.sql.SQLException;
import java.util.List;


public class CustomerServices {

    private static SessionFactory sessionFactory;
    private static Session session;


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


    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void setSessionFactory(SessionFactory sessionFactory) {
        CustomerServices.sessionFactory = sessionFactory;
    }

    public static Session getSession() {
        return session;
    }

    public static void setSession(Session session) {
        CustomerServices.session = session;
    }
}
