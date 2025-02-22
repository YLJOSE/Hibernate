package EjercicioAlumnoNotasYCursos.DAO;

import EjercicioAcualizado.Generics.DAO;
import EjercicioAlumnoNotasYCursos.Objetos.Alumno;
import EjercicioPersonaTieneVariasMotosYCarros.Objetos.Persona;
import Utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AlumnoDAO implements DAO<Alumno> {
    @Override
    public boolean save(Alumno entity) {
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
    public boolean update(Alumno entity) {
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
    public Alumno getById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Alumno.class, id);
        }
    }

    @Override
    public List<Alumno> getAll() {
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();

            return session.createQuery("from Alumno", Alumno.class).list();
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
            Alumno alumno = getById(id);
            if (alumno != null) {
                session.remove(alumno);
                System.out.println("alumno is deleted");
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
