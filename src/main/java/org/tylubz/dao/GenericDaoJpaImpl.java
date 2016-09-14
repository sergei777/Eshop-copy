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

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }


    public void setEntityClass(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    public Class<E> getEntityClass() {
        return entityClass;
    }

    public GenericDaoJpaImpl(Class<E> entity){
        entityManager = ServletContextListenerImpl.createEntityManager();
        entityClass = entity;
    }

    public GenericDaoJpaImpl(EntityManager em,Class<E> entity){
        entityManager = em;
        entityClass = entity;
    }


    public E create(E newInstance) throws DaoStoreException{
        EntityTransaction trx = getEntityManager().getTransaction();
        try{
            trx.begin();
            getEntityManager().persist(newInstance);
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
        EntityTransaction trx = getEntityManager().getTransaction();
        try{
            trx.begin();
            e = getEntityManager().find(getEntityClass(),id);
            trx.commit();
        }
        finally {
            if(trx.isActive()) trx.rollback();
        }
        return e;
    }

    public List<E> readAll() {
        return getEntityManager()
                .createQuery("select x from " + getEntityClass().getSimpleName() + " x")
                .getResultList();
    }

    public void update(E entity) throws DaoStoreException{
        EntityTransaction trx = getEntityManager().getTransaction();
        try{
            trx.begin();
            getEntityManager().merge(entity);
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
        EntityTransaction trx = getEntityManager().getTransaction();
        try{
            trx.begin();
            getEntityManager().remove(entity);
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
