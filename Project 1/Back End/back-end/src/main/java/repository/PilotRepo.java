package repository;

import org.hibernate.Session;

import model.Pilot;
import org.hibernate.Transaction;
import utils.HibernateUtil;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;



public class PilotRepo {

    public static Pilot getPilotById(int id) {
        Session session = HibernateUtil.getSession();
        return session.get(Pilot.class, id);
    }

    public static List<Pilot> getAllPilots() {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Pilot> query = builder.createQuery(Pilot.class);
        Root<Pilot> root = query.from(Pilot.class);
        query.select(root);

        transaction.commit();//Has database update the available column to match the above change
        return session.createQuery(query).getResultList();
    }

    public static void saveNewPilot(Pilot pilot) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        session.save(pilot);

        transaction.commit();//Has database update the available column to match the above change
    }

    public static void deletePilot(Pilot pilot) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        session.delete(pilot);

        transaction.commit();//Has database update the available column to match the above change
    }

}