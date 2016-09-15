package org.tylubz.dao.interfaces;

import org.tylubz.dao.exceptions.DaoStoreException;

import java.io.Serializable;
import java.util.List;

/**
 * Interface for manipulating operations with entities
 * CRUD operations
 *
 * @param <E>  Entity
 * @param <PK> Primary key
 *
 */
public interface GenericDao<E, PK extends Serializable> {
    /**
     * Method for creation new Instance in database
     *
     * @param newInstance
     * @return new entity
     * @throws DaoStoreException
     */
    E create(E newInstance) throws DaoStoreException;

    /**
     * Return entity by primary key
     *
     * @param id primary key
     * @return entity
     * @throws DaoStoreException
     */
    E read(PK id) throws DaoStoreException;

    /**
     * updates entity
     *
     * @param transientObject entity for updating
     * @throws DaoStoreException
     */
    void update(E transientObject) throws DaoStoreException;

    /**
     * delete entity from database
     *
     * @param persistentObject removing entity
     * @throws DaoStoreException
     */
    void delete(E persistentObject) throws DaoStoreException;
}
