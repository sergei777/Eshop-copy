package org.tylubz.service;

import org.tylubz.dao.GenericDao;
import org.tylubz.dao.GenericDaoJpaImpl;
import org.tylubz.dao.exceptions.DaoStoreException;

import java.io.Serializable;

/**
 * Created by Sergei on 21.08.2016.
 */
public class GenericService<E, PK extends Serializable> {

    private GenericDaoJpaImpl<E, PK> genericDao;

    public GenericService(Class<E> entity){
        genericDao = new GenericDaoJpaImpl<E, PK>(entity);
    }

    public E create(E newInstance) throws DaoStoreException{
        genericDao.create(newInstance);
        return newInstance;
    }

    public E read(PK id) {
        return genericDao.read(id);
    }

    public void update(E entity) throws DaoStoreException {
        genericDao.update(entity);
    }

    public void delete(E entity) throws DaoStoreException {
        genericDao.delete(entity);
    }
}
