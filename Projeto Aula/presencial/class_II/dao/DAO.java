package dao;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    
    Optional<T> getbyID(long id);
    
    List<T> getAll();
    
    boolean save(T t);
    
    boolean updatebyID(T t);
    
    boolean deletebyID(T t);
}
