package EjercicioAcualizado.Generics;


import java.util.List;

public interface DAO<T> {
    boolean save(T entity);

    boolean update(T entity);

    T getById(int id);

    List<T> getAll();

    boolean delete(int id);

}
