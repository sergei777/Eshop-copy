package org.tylubz.dao;

import org.tylubz.dao.exceptions.DaoStoreException;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Sergei on 21.08.2016.
 */
public interface GenericDao<E, PK extends Serializable> {
    E create(E newInstance) throws DaoStoreException;
    E read(PK id) throws DaoStoreException;
    List<E> readAll();
    void update(E transientObject) throws DaoStoreException;
    void delete(E persistentObject) throws DaoStoreException;
}
