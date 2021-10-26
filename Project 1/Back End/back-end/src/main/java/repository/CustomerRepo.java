package repository;

import org.hibernate.Session;
import model.Customer;
import utils.HibernateUtil;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


public class CustomerRepo {
    private static Session session = HibernateUtil.getSession();
    private static Transaction transaction;

    //Gets one row from the customer table using the customer id
    public static Customer getCustomerById(Integer id) {
        return session.get(Customer.class, id);
    }

    //Gets the data for one customer using that customer's username
    public static Customer getByUsername(String username) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Customer> criteria = builder.createQuery(Customer.class);
        Root<Customer> root = criteria.from(Customer.class);
        criteria.select(root).where(builder.equal(root.get("username"), username));
        return session.createQuery(criteria).getSingleResult();

    }

    //Gets all data in the customer table
    public static List<Customer> getAllCustomers() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Customer> query = builder.createQuery(Customer.class);
        Root<Customer> root = query.from(Customer.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }

    //Adds a new customer to the customer table
    public static void saveNewCustomer( Customer customer){
        transaction = session.beginTransaction();

        session.save(customer);

        transaction.commit();
    }

    //Removes a customer from the customer table
    public static void deleteCustomer(Customer customer) {
        transaction = session.beginTransaction();

        session.delete(customer);

        transaction.commit();
    }

}