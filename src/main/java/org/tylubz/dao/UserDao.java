package org.tylubz.dao;

import org.tylubz.entity.UserEntity;

import javax.persistence.Query;

/**
 * Created by Sergei on 03.09.2016.
 */
public class UserDao extends GenericDaoJpaImpl{

    public UserDao(Class entity) {
        super(entity);
    }


    public UserEntity getEntityByUsernameAndPassword(String username, String password){
        String queryString = "SELECT a FROM UserEntity AS a WHERE a.username = :username AND a.password = :password";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("username",username);
        query.setParameter("password",password);
        return (UserEntity)query.getResultList().get(0);
    }

    public UserEntity getEntityByUsername(String username){
        String queryString = "SELECT a FROM UserEntity AS a WHERE a.username = :username";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("username",username);
        return (UserEntity)query.getResultList().get(0);
    }
}
