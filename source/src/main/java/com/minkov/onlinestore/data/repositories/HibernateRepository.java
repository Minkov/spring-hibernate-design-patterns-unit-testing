package com.minkov.onlinestore.data.repositories;

import com.minkov.onlinestore.data.entities.base.EntityModel;
import com.minkov.onlinestore.data.repositories.base.GenericRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class HibernateRepository<T extends EntityModel> implements GenericRepository<T> {

    private SessionFactory sessionFactory;
    private Class<T> entityModelClass;

    @Autowired
    public HibernateRepository(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    @Override
    public List<T> getAll() throws Exception {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<T> criteriaQuery = builder.createQuery(getEntityModelClass());
        criteriaQuery.from(getEntityModelClass());

        List<T> entities = session.createQuery(criteriaQuery)
            .getResultList();

        transaction.commit();
        session.close();

        return entities;
    }

    @Override
    public T create(T entity) throws Exception {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session
            .save(entity);

        transaction.commit();
        session.close();
        return entity;
    }

    @Override
    public T getById(int id) throws Exception {
        Session session = getSessionFactory().openSession();

        T entity = session.get(getEntityModelClass(), id);

        session.close();
        return entity;
    }


    @Override
    public void update(T entity) {

    }

    @Override
    public void update(int id, T entity) {

    }

    @Override
    public void delete(T entity) {

    }

    @Override
    public void delete(int id) {

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Class<T> getEntityModelClass() {
        return entityModelClass;
    }

    public void setEntityModelClass(Class<T> klass) {
        entityModelClass = klass;
    }

}
