package org.tylubz.dao.impl;

import org.tylubz.dao.exceptions.DaoStoreException;
import org.tylubz.dao.interfaces.GenericDao;
import org.tylubz.utils.ServletContextListenerImpl;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Implementation of GenericDao
 *
 * @param <E>  Entity
 * @param <PK> Primary key
 * @author Sergei
 */
public class GenericDaoJpaImpl<E, PK extends Serializable>
        implements GenericDao<E, PK> {

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

    public GenericDaoJpaImpl(Class<E> entity) {
        entityManager = ServletContextListenerImpl.createEntityManager();
        entityClass = entity;
    }

    /**
     * creates new entity
     *
     * @param newInstance
     * @return
     * @throws DaoStoreException
     */
    public E create(E newInstance) throws DaoStoreException {
        EntityTransaction trx = getEntityManager().getTransaction();
        try {
            trx.begin();
            getEntityManager().persist(newInstance);
            trx.commit();
        } catch (PersistenceException ex) {
            throw new DaoStoreException(ex);
        } finally {
            if (trx.isActive()) trx.rollback();
        }
        return newInstance;
    }

    /**
     * read entity from db
     *
     * @param id primary key
     * @return entity
     */
    public E read(PK id) {
        E e = null;
        EntityTransaction trx = getEntityManager().getTransaction();
        try {
            trx.begin();
            e = getEntityManager().find(getEntityClass(), id);
            trx.commit();
        } finally {
            if (trx.isActive()) trx.rollback();
        }
        return e;
    }

    /**
     * update entity in db
     *
     * @param entity for updating
     * @throws DaoStoreException
     */
    public void update(E entity) throws DaoStoreException {
        EntityTransaction trx = getEntityManager().getTransaction();
        try {
            trx.begin();
            getEntityManager().merge(entity);
            trx.commit();
        } catch (PersistenceException ex) {
            throw new DaoStoreException(ex);
        } finally {
            if (trx.isActive()) trx.rollback();
        }
    }

    /**
     * delete entity from db
     *
     * @param entity for deleting
     * @throws DaoStoreException
     */
    public void delete(E entity) throws DaoStoreException {
        EntityTransaction trx = getEntityManager().getTransaction();
        try {
            trx.begin();
            getEntityManager().remove(entity);
            trx.commit();
        } catch (PersistenceException ex) {
            throw new DaoStoreException(ex);
        } finally {
            if (trx.isActive()) trx.rollback();
        }
    }

}
