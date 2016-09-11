package org.tylubz.servlet;

import org.tylubz.dao.UserDao;
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
import java.util.Date;
import java.util.Locale;

/**
 * Created by Sergei on 05.09.2016.
 */
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao = new UserDao(UserEntity.class);
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
            e.printStackTrace();
        }
        user.setUserType("user");
        if(req.getParameter("city")!=null){
            AddressEntity addressEntity = new AddressEntity();
            addressEntity.setCountry(req.getParameter("country"));
            addressEntity.setCity(req.getParameter("city"));
            addressEntity.setPostcode(Integer.valueOf(req.getParameter("postcode")));
            addressEntity.setHouseNumber(Integer.valueOf(req.getParameter("house_number")));
            addressEntity.setDoor(Integer.valueOf(req.getParameter("floar_number")));
            user.setAddressEntity(addressEntity);
        }
        userDao.create(user);
    }

    public static void main(String[] args) {
        String string = "12.12.1994";
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ENGLISH);
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
        //LocalDate date = LocalDate.parse(string, formatter);
        try {
            Date newDate = format.parse(string);
            System.out.println(newDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
