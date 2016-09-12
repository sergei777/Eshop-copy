package org.tylubz.servlet;

import org.tylubz.dao.UserDao;
import org.tylubz.entity.UserEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Sergei on 11.09.2016.
 */
public class UserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        //System.out.println(req.getParameter("operation"));
        if("change".equals(req.getParameter("operation"))){
            int id = Integer.valueOf(req.getParameter("id"));
            req.setAttribute("user",(UserEntity)userDao.read(id));
            req.getRequestDispatcher("/admin/updateuser.jsp").forward(req,resp);
        }
        else {
            List<UserEntity> list = userDao.getAllUserEntity();
            req.setAttribute("userList", list);
        }
        //req.getRequestDispatcher("/admin/userlist.jsp").forward(req,resp);
    }
}
