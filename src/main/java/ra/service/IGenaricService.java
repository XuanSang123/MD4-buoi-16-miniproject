package ra.service;

import java.util.List;

public interface IGenaricService <T,E>{
    List<T> findAll();
    T finById(E id);
    void save(T t);
    Object delete(E id);
}
