package org.tylubz.dao.impl;

import org.tylubz.entity.UserEntity;

import javax.persistence.Query;
import java.util.List;

/**
 * Dao for UserEntity
 */
public class UserDao extends GenericDaoJpaImpl {

    public UserDao() {
        super(UserEntity.class);
    }

    /**
     * returns entity by username
     * and password
     *
     * @param username
     * @param password
     * @return entity
     */
    public UserEntity getEntityByUsernameAndPassword(String username, String password) {
        String queryString = "SELECT a FROM UserEntity AS a WHERE a.username = :username AND a.password = :password";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("username", username);
        query.setParameter("password", password);
        return (UserEntity) query.getResultList().get(0);
    }

    /**
     * return entity by username
     *
     * @param username
     * @return entity
     */
    public UserEntity getEntityByUsername(String username) {
        String queryString = "SELECT a FROM UserEntity AS a WHERE a.username = :username";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("username", username);
        return (UserEntity) query.getResultList().get(0);
    }

    /**
     * retutn all entities in db
     *
     * @return list of entities
     */
    public List<UserEntity> getAllUserEntity() {
        String queryString = "SELECT a FROM UserEntity a";
        Query query = entityManager.createQuery(queryString);
        return (List<UserEntity>) query.getResultList();
    }
}
