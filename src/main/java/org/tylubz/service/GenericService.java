package org.tylubz.service;

import org.tylubz.dao.GenericDao;
import org.tylubz.dao.GenericDaoJpaImpl;

import java.io.Serializable;

/**
 * Created by Sergei on 21.08.2016.
 */
public class GenericService<E, PK extends Serializable> {

    private GenericDaoJpaImpl<E, PK> genericDao;

    public E create(E newInstance) {
        genericDao.create(newInstance);
        return newInstance;
    }

    public E read(PK id) {
        return genericDao.read(id);
    }

    public void update(E entity) {
        genericDao.update(entity);
    }

    public void delete(E entity) {
        genericDao.delete(entity);
    }
}
