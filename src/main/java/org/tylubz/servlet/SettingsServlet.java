package org.tylubz.servlet;

import org.tylubz.dao.impl.UserDao;
import org.tylubz.entity.UserEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * For redirecting to user settings
 *
 * @author Sergei
 */
public class SettingsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    /**
     * Add data to session
     * and set to settings
     *
     * @param req  for extracting data
     * @param resp for setting status
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        String username = req.getSession().getAttribute("username").toString();
        String password = req.getSession().getAttribute("password").toString();
        UserEntity userEntity = userDao.getEntityByUsernameAndPassword(username, password);
        req.setAttribute("user", userEntity);
        req.getRequestDispatcher("/settings.jsp").forward(req, resp);
    }
}
