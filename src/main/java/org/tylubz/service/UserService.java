package org.tylubz.service;

import org.tylubz.dao.UserDao;
import org.tylubz.entity.UserEntity;

/**
 * Created by Sergei on 11.09.2016.
 */
public class UserService extends GenericService{

    private UserDao userDao;

    public UserService() {
        super(UserEntity.class);
    }
    
}
