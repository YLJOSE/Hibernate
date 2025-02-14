package DAOS;

import Utils.HibernateUtil;
import jakarta.transaction.SystemException;
import models.Cart;
import models.Item;
import models.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ItemDAO {

    public boolean saveItem(Item item) throws SystemException {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.persist(item);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();

            }
            return false;
        }
    }

    public boolean updateItem(Item item) throws SystemException {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.merge(item);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }

    public Item getItemById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Item.class, id);
        }
    }

    public List<Item> getAllItems() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from ITEMS", Item.class).list();
        }
    }

    public boolean deleteItem(int id) throws SystemException {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Item student = getItemById(id);
            if (student != null) {
                session.remove(student);
                System.out.println("Item is deleted");
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
