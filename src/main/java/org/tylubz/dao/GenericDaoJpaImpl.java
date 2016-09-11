package org.tylubz.dao;

import org.tylubz.utils.ServletContextListenerImpl;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

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

    public E create(E newInstance) {
        EntityTransaction trx = entityManager.getTransaction();
        try{
            trx.begin();
            entityManager.persist(newInstance);
            trx.commit();
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

    public void update(E entity) {
        entityManager.merge(entity);
    }

    public void delete(E entity) {
        EntityTransaction trx = entityManager.getTransaction();
        try{
            trx.begin();
        entityManager.remove(entity);
            trx.commit();
        }
        finally {
            if(trx.isActive()) trx.rollback();
        }
    }

}
