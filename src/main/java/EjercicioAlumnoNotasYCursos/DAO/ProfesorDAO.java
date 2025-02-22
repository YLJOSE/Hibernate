package EjercicioAlumnoNotasYCursos.DAO;

import EjercicioAcualizado.Generics.DAO;
import EjercicioAlumnoNotasYCursos.Objetos.Profesor;
import EjercicioPersonaTieneVariasMotosYCarros.Objetos.Persona;
import Utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProfesorDAO implements DAO<Profesor> {
    @Override
    public boolean save(Profesor entity) {
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
    public boolean update(Profesor entity) {
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
    public Profesor getById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Profesor.class, id);
        }
    }

    @Override
    public List<Profesor> getAll() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();

            return session.createQuery("from Profesor", Profesor.class).list();
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
            Profesor profesor = getById(id);
            if (profesor != null) {
                session.remove(profesor);
                System.out.println("profesor is deleted");
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
