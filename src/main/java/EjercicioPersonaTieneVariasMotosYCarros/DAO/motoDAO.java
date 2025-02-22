package EjercicioPersonaTieneVariasMotosYCarros.DAO;

import EjercicioAcualizado.Generics.DAO;
import EjercicioPersonaTieneVariasMotosYCarros.Objetos.Motos;
import Utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class motoDAO implements DAO<Motos> {
    @Override
    public boolean save(Motos entity) {
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
    public boolean update(Motos entity) {

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
    public Motos getById(int id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            return session.get(Motos.class, id);
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Motos> getAll() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            return session.createQuery("from Motos", Motos.class).list();
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
            Motos motos = getById(id);
            if (motos != null) {
                session.remove(motos);
                System.out.println("motos is deleted");
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
