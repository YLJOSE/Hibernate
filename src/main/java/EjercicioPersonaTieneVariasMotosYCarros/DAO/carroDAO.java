package EjercicioPersonaTieneVariasMotosYCarros.DAO;

import EjercicioAcualizado.Generics.DAO;
import EjercicioPersonaTieneVariasMotosYCarros.Objetos.Carros;
import EjercicioPersonaTieneVariasMotosYCarros.Objetos.Motos;
import Utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class carroDAO implements DAO<Carros> {
    @Override
    public boolean save(Carros entity) {
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
    public boolean update(Carros entity) {
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
    public Carros getById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Carros.class, id);
        }
    }

    @Override
    public List<Carros> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Carros", Carros.class).list();
        }
    }

    @Override
    public boolean delete(int id) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Carros carro = getById(id);
            if (carro != null) {
                session.remove(carro);
                System.out.println("carro is deleted");
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
