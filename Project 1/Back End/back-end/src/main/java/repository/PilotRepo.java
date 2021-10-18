package repository;

import org.hibernate.Session;
import model.Pilot;
import utils.HibernateUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;



public class PilotRepo {
    private static Session session = HibernateUtil.getSession();

    public static Pilot getPilotById(int id) {
        return session.get(Pilot.class, id);
    }

    public static List<Pilot> getAllPilots() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Pilot> query = builder.createQuery(Pilot.class);
        Root<Pilot> root = query.from(Pilot.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }

    public static void saveNewPilot(Pilot pilot) {
        session.save(pilot);
    }

    public static void deletePilot(Pilot pilot) {
        session.delete(pilot);
    }

}