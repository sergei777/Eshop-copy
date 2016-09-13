package org.tylubz.dao;

import org.tylubz.dao.exceptions.DaoStoreException;
import org.tylubz.utils.ServletContextListenerImpl;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Sergei on 21.08.2016.
 */
public class GenericDaoJpaImpl<E,PK extends Serializable>
        implements GenericDao<E,PK> {

    protected Class<E> entityClass;

    protected EntityManager entityManager;

    public GenericDaoJpaImpl(Class<E> entity){
        entityManager = ServletContextListenerImpl.createEntityManager();
        entityClass = entity;
    }

    public E create(E newInstance) throws DaoStoreException{
        EntityTransaction trx = entityManager.getTransaction();
        try{
            trx.begin();
            entityManager.persist(newInstance);
            trx.commit();
        }
        catch (PersistenceException ex){
            throw new DaoStoreException(ex);
        }
        finally {
            if(trx.isActive()) trx.rollback();
        }
        return newInstance;
    }

    public E read(PK id) {
        E e = null;
        EntityTransaction trx = entityManager.getTransaction();
        try{
            trx.begin();
            e = entityManager.find(entityClass,id);
            trx.commit();
        }
        finally {
            if(trx.isActive()) trx.rollback();
        }
        return e;
    }

    public List<E> readAll() {
        return entityManager
                .createQuery("select x from " + entityClass.getSimpleName() + " x")
                .getResultList();
    }

    public void update(E entity) throws DaoStoreException{
        EntityTransaction trx = entityManager.getTransaction();
        try{
            trx.begin();
            entityManager.merge(entity);
            trx.commit();
        }
        catch (PersistenceException ex){
            throw new DaoStoreException(ex);
        }
        finally {
            if(trx.isActive()) trx.rollback();
        }
    }

    public void delete(E entity) throws DaoStoreException{
        EntityTransaction trx = entityManager.getTransaction();
        try{
            trx.begin();
        entityManager.remove(entity);
            trx.commit();
        }
        catch (PersistenceException ex){
            throw new DaoStoreException(ex);
        }
        finally {
            if(trx.isActive()) trx.rollback();
        }
    }

}
