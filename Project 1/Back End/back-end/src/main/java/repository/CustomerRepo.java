package repository;

import model.Flight;
import org.hibernate.Session;
import model.Customer;
import org.hibernate.SessionFactory;
import servlets.DependencyLoaderListener;
import utils.HibernateUtil;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


public class CustomerRepo {
    private static Session session = HibernateUtil.getSession();
    private static Transaction transaction;

    public static Customer getCustomerById(Integer id) {
        return session.get(Customer.class, id);
    }

    public static Customer login(String username, String password) {
        transaction = session.beginTransaction();


        Customer user = (Customer) session.createQuery("FROM Customer c WHERE c.username = :userName").setParameter("userName", username).uniqueResult();



        if (user != null && user.getPassword().equals(password)){
            return user;
        }

        transaction.commit();//Has database update the available column to match the above change
        return null;

    }




    public static List<Customer> getAllCustomers() {
        transaction = session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Customer> query = builder.createQuery(Customer.class);
        Root<Customer> root = query.from(Customer.class);
        query.select(root);
        List list = session.createQuery(query).getResultList();

        transaction.commit();//Has database update the available column to match the above change

        return list;
    }

    public static void saveNewCustomer( Customer customer){
        transaction = session.beginTransaction();

        session.save(customer);

        transaction.commit();//Has database update the available column to match the above change
    }

    public static void deleteCustomer(Customer customer) {
        transaction = session.beginTransaction();

        session.delete(customer);

        transaction.commit();//Has database update the available column to match the above change
    }

}