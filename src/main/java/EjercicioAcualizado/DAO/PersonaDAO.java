package EjercicioAcualizado.DAO;

import EjercicioAcualizado.Generics.DAO;
import EjercicioAcualizado.Objetos.Persona;
import Utils.HibernateUtil;
import models.Student;
import models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PersonaDAO implements DAO<Persona> {

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
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from personas", Persona.class).list();
        }
    }

    @Override
    public boolean delete(int id) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Persona student = getById(id);
            if (student != null) {
                session.remove(student);
                System.out.println("Student is deleted");
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
