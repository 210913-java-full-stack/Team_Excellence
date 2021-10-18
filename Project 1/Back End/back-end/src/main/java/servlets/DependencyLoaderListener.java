package servlets;

import model.*;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.CachedNaturalIdValueSource;
import services.CancelFlight;
import utils.HibernateUtil;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;

public class DependencyLoaderListener  implements ServletContextListener {
    Session session;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        session = HibernateUtil.getSession();

        TestEntity testEntity = new TestEntity("this is a test");

        Transaction tx = session.beginTransaction();
        session.save(testEntity);
        tx.commit();



//        CancelFlight cf = new CancelFlight();
//        cf.cancelFlight(846754);

    }


    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        try {
            HibernateUtil.getSession().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}