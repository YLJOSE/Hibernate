package EjercicioAlumnoNotasYCursos.DAO;

import EjercicioAcualizado.Generics.DAO;
import EjercicioAlumnoNotasYCursos.Objetos.Asignatura;
import Utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AsignaturaDAO implements DAO<Asignatura> {
    @Override
    public boolean save(Asignatura entity) {
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
    public boolean update(Asignatura entity) {
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
    public Asignatura getById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Asignatura.class, id);
        }
    }

    @Override
    public List<Asignatura> getAll() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            return session.createQuery("from Asignatura", Asignatura.class).list();
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
            Asignatura asignatura = getById(id);
            if (asignatura != null) {
                session.remove(asignatura);
                System.out.println("asignatura is deleted");
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
