package org.tylubz.servlet;

import org.tylubz.dao.impl.UserDao;
import org.tylubz.entity.UserEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Operation for entering to system
 */
public class SignInServlet extends HttpServlet {
    /**
     * Outs of session
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation = req.getParameter("sign-out");
        if (operation.equals("out")) {
            req.getSession().invalidate();
            resp.sendRedirect("/index.jsp");
            return;
        }
    }

    /**
     * Entering to system
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        UserEntity user = userDao.getEntityByUsernameAndPassword(req.getParameter("login"), req.getParameter("password"));
        if (user != null) {
            req.getSession().setAttribute("first_name", user.getFirstName());
            req.getSession().setAttribute("username", user.getUsername());
            req.getSession().setAttribute("id", user.getId());
            req.getSession().setAttribute("userAttr", user.getUserType());
            req.getSession().setAttribute("password", user.getPassword());
            String url = user.getUserType().equals("user") ? "/index.jsp" : "/admin.jsp";
            PrintWriter out = resp.getWriter();
            out.print(url);
            out.close();
        } else {
            resp.sendError(500);
        }
    }
}