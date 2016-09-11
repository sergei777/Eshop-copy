package org.tylubz.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Sergei on 28.08.2016.
 */
public class ServletContextListenerImpl implements ServletContextListener {

    private static EntityManagerFactory emf;

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        emf = Persistence.createEntityManagerFactory("myapp");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        emf.close();
    }

    public static EntityManager createEntityManager(){
        if (emf == null){
            throw new IllegalStateException("Context is not initialized yet");
        }
        return emf.createEntityManager();
    }
}
