package EjercicioPersonaTieneVariasMotosYCarros.DAO;

import EjercicioAcualizado.Generics.DAO;
import EjercicioPersonaTieneVariasMotosYCarros.Objetos.Persona;
import Utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class personaDAO implements DAO<Persona> {
    @Override
    public boolean save(Persona entity) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();

            }
            return false;
        }
    }

    @Override
    public boolean update(Persona entity) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.merge(entity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }

    @Override
    public Persona getById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Persona.class, id);
        }
    }

    @Override
    public List<Persona> getAll() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            return session.createQuery("from Persona", Persona.class).list();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(int id) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Persona persona = getById(id);
            if (persona != null) {
                session.remove(persona);
                System.out.println("persona is deleted");
            }
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }
}
