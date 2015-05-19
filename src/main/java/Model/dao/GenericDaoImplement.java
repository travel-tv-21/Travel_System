package Model.dao;

import Model.dao.interfaces.GenericDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
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
    public void update(final T object) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(object);
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
    }

    @Override

    public void delete(final T object) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();

            session.delete(object);
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
    }

    @Override
    public T findById(final Class<T> type,int id) {
        Session session = sessionFactory.openSession();
        T res = null;
        try {
            res = ((T) session.get(type, id));
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
        return res;
    }

    @Override
    public List<T> findAll(final Class<T> type) {
        Session session = sessionFactory.openSession();
        List<T> some = new ArrayList<T>();
        try {
            some = (List<T>) session.createCriteria(type).list();
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
        return some;

    }
}
