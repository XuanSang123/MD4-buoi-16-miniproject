package ra.dao;

import java.util.List;

public interface IGenaricDao<T, E> {
    List<T> findAll();

    T finById(E id);

    void create(T t);

    void update(T t);

    void delete(E id);
}
