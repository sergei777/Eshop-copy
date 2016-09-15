package org.tylubz.utils;

import org.apache.log4j.PropertyConfigurator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.File;

/**
 * Class for initializing properties
 *
 * @author Sergei
 */
public class ServletContextListenerImpl implements ServletContextListener {

    private static EntityManagerFactory emf;

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        emf = Persistence.createEntityManagerFactory("myapp");

        ServletContext context = servletContextEvent.getServletContext();
        String homeDir = context.getRealPath("/");
        File propertiesFile = new File(homeDir,"WEB-INF/classes/log4j.properties");
        PropertyConfigurator.configure(propertiesFile.toString());
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        emf.close();
    }

    public static EntityManager createEntityManager() {
        if (emf == null) {
            throw new IllegalStateException("Context is not initialized yet");
        }
        return emf.createEntityManager();
    }
}
