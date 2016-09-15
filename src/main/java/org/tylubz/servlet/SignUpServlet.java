package org.tylubz.servlet;

import org.tylubz.dao.impl.UserDao;
import org.tylubz.dao.exceptions.DaoStoreException;
import org.tylubz.entity.AddressEntity;
import org.tylubz.entity.UserEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Class for manipulating with user
 * entities
 *
 * @author Sergei
 */
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            addNewUser(req, resp);
        } catch (DaoStoreException e) {
            resp.setStatus(500);
        }
    }

    /**
     * creates new user entity in db
     *
     * @param req  for extracting data
     * @param resp for setting url
     * @throws IOException
     * @throws DaoStoreException
     */
    public void addNewUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, DaoStoreException {
        UserDao userDao = new UserDao();
        req.setCharacterEncoding("UTF-8");
        UserEntity user = new UserEntity();
        user.setFirstName(req.getParameter("first_name"));
        user.setUsername(req.getParameter("username"));
        user.setSecondName(req.getParameter("last_name"));
        user.setPassword(req.getParameter("password"));
        user.setEmail(req.getParameter("email"));
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
        try {
            user.setBirthDate(format.parse(req.getParameter("birth_date").toString()));
        } catch (ParseException e) {
            resp.setStatus(500);
        }
        user.setUserType("user");
        if (!"".equals(req.getParameter("city"))) {
            user.setAddressEntity(createAddressEntity(req));
        }
        userDao.create(user);
        resp.sendRedirect("/index.jsp");
    }

    /**
     * creates new AddressEntity
     * and returns it
     *
     * @param req for extractiong data
     * @return entity
     */
    public AddressEntity createAddressEntity(HttpServletRequest req) {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setCountry(req.getParameter("country"));
        addressEntity.setCity(req.getParameter("city"));
        addressEntity.setPostcode(Integer.valueOf(req.getParameter("postcode")));
        addressEntity.setHouseNumber(Integer.valueOf(req.getParameter("house_number")));
        addressEntity.setDoor(Integer.valueOf(req.getParameter("float_number")));
        return addressEntity;
    }
}
