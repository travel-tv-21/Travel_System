package Model.dao;

import Model.dao.interfaces.GenericDao;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import org.hibernate.SessionFactory;
/**
 * Created by Администратор on 02.05.2015.
 */
    public class GenericDaoImplement<T> implements GenericDao<T> {
    private SessionFactory sessionFactory;

    @Autowired
    public GenericDaoImplement(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(final T object) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(object);
            session.getTransaction().commit();
        }finally {
            if (session != null && session.isOpen())
                session.close();
        }
    }

    @Override
    public void update(T object) {

    }

    @Override
    public void delete(T object) {

    }

    @Override
    public T findById(int id) {
        return null;
    }

    @Override
    public List<T> findAll() {
        return null;
    }
}
