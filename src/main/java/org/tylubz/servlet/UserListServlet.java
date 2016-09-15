package org.tylubz.servlet;

import org.tylubz.dao.impl.UserDao;
import org.tylubz.dao.exceptions.DaoStoreException;
import org.tylubz.entity.UserEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

/**
 * Class for making operations with
 * users in db
 *
 * @author Sergei
 */
public class UserListServlet extends HttpServlet {
    /**
     * Returns all users or redirect to update page
     *
     * @param req  for extracting data
     * @param resp for setting status
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        if ("change".equals(req.getParameter("operation"))) {
            int id = Integer.valueOf(req.getParameter("id"));
            req.setAttribute("user", userDao.read(id));
            req.getRequestDispatcher("/admin/updateuser.jsp").forward(req, resp);
        }
        if ("getUserList".equals(req.getParameter("operation"))) {
            List<UserEntity> list = userDao.getAllUserEntity();
            req.setAttribute("userList", list);
            resp.sendRedirect("/admin/productlist.jsp");
        }
    }

    /**
     * update user information
     *
     * @param req  for extracting data
     * @param resp for setting status
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        if ("updateUserMainInformation".equals(req.getParameter("operation"))) {
            UserDao userDao = new UserDao();
            UserEntity entity = (UserEntity) userDao.read(Integer.valueOf(req.getParameter("id")));
            DateFormat format = new SimpleDateFormat("yyyy.MM.dd", Locale.ENGLISH);
            entity.setEmail(req.getParameter("email"));
            entity.setFirstName(req.getParameter("first_name"));
            entity.setSecondName(req.getParameter("last_name"));
            entity.setPassword(req.getParameter("password"));
            entity.setUsername(req.getParameter("username"));
            try {
                userDao.update(entity);
                entity.setBirthDate(format.parse(req.getParameter("birth_date")));
            } catch (DaoStoreException e) {
                resp.setStatus(500);
            } catch (ParseException e) {
                resp.setStatus(500);
            }
            if ("admin".equals(req.getParameter("userType"))) {
                resp.sendRedirect("/admin.jsp");
            } else {
                resp.sendRedirect("/index.jsp");
            }
        }
    }
}
