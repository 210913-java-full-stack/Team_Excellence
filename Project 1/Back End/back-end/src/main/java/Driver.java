import model.*;
import services.CancelFlight;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import servlets.DependencyLoaderListener;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Driver {
    public static void main(String[] args){

        Session session = DependencyLoaderListener.getSession();

        Transaction transaction = session.beginTransaction();
        CancelFlight.cancelFlight(1);
        transaction.commit();
        
    }
}
