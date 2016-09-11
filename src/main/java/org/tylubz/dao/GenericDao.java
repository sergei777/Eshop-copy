package org.tylubz.dao;

import java.io.Serializable;

/**
 * Created by Sergei on 21.08.2016.
 */
public interface GenericDao<E, PK extends Serializable> {
    E create(E newInstance);
    E read(PK id);
    void update(E transientObject);
    void delete(E persistentObject);
}
