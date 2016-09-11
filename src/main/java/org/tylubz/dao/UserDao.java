package org.tylubz.dao;

import org.tylubz.entity.User;

import javax.persistence.Query;

/**
 * Created by Sergei on 03.09.2016.
 */
public class UserDao extends GenericDaoJpaImpl{
    public UserDao(Class entity) {
        super(entity);
    }

    public User getEntityByUsernameAndPassword(String username, String password){
        String queryString = "SELECT a FROM User AS a WHERE a.username = :username AND a.password = :password";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("username",username);
        query.setParameter("password",password);
        return (User)query.getResultList().get(0);
    }
}
