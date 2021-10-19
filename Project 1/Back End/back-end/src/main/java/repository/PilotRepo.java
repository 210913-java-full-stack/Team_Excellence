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
    private Session session = HibernateUtil.getSession();

    public Pilot getPilotById(int id) {
        return session.get(Pilot.class, id);
    }

    public List<Pilot> getAllPilots() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Pilot> query = builder.createQuery(Pilot.class);
        Root<Pilot> root = query.from(Pilot.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }

    public void saveNewPilot(Pilot pilot) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(pilot);
        transaction.commit();
    }

    public void deletePilot(Pilot pilot) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(pilot);
        transaction.commit();
    }

}