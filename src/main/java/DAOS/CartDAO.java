package DAOS;

import Utils.HibernateUtil;
import jakarta.transaction.SystemException;
import models.Cart;
import models.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CartDAO {

    public boolean saveCart(Cart cart) throws SystemException {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.persist(cart);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();

            }
            return false;
        }
    }

    public boolean updateCart(Cart cart) throws SystemException {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.merge(cart);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }

    public Cart getCartById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Cart.class, id);
        }
    }

    public List<Cart> getAllCarts() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Cart", Cart.class).list();
        }
    }

    public boolean deleteCart(int id) throws SystemException {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Cart student = getCartById(id);
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
