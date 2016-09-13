package org.tylubz.servlet;

import org.tylubz.dao.UserDao;
import org.tylubz.entity.UserEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Sergei on 03.09.2016.
 */
public class LoginCheckServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation = req.getParameter("sign-out");
        if(operation.equals("out")){
            req.getSession().invalidate();
            resp.sendRedirect("/index.jsp");
            return;
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao = new UserDao(UserDao.class);
        //try {
        System.out.println(req.getParameter("login"));
        System.out.println(req.getParameter("password"));
            UserEntity user = userDao.getEntityByUsernameAndPassword(req.getParameter("login"), req.getParameter("password"));
        if(user!=null) {
            System.out.println("i'm here!");
            req.getSession().setAttribute("first_name", user.getFirstName());
            req.getSession().setAttribute("username", user.getUsername());
            req.getSession().setAttribute("password", user.getPassword());
            req.getSession().setAttribute("user", user);
            String url = user.getUserType().equals("user") ? "/index.jsp" : "/admin.jsp";
            PrintWriter out = resp.getWriter();
            out.print(url);
            out.close();
            //req.getRequestDispatcher("/" + url + ".jsp").forward(req, resp);
            //resp.setStatus(200);
        }
        else {
            resp.sendError(500);
//            PrintWriter out = resp.getWriter();
//            out.println("error");
//            out.close();
        }
    }
}