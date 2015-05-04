package Model.dao.interfaces;

import java.util.List;

/**
 * Created by Администратор on 02.05.2015.
 */
public interface GenericDao <T> {
  void create (T object);
  void update (T object);
  void delete (T object);
  T findById(int id);
  List<T> findAll();
}
