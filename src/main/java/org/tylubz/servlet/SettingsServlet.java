package org.tylubz.servlet;

import org.tylubz.dao.UserDao;
import org.tylubz.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Sergei on 07.09.2016.
 */
public class SettingsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao = new UserDao(User.class);
        String username = req.getSession().getAttribute("username").toString();
        String password = req.getSession().getAttribute("password").toString();
        User userEntity = userDao.getEntityByUsernameAndPassword(username,password);
        req.setAttribute("user",userEntity);
        req.getRequestDispatcher("/settings.jsp").forward(req,resp);
    }
}
