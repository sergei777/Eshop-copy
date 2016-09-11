package org.tylubz.servlet;

import org.tylubz.dao.UserDao;
import org.tylubz.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Sergei on 05.09.2016.
 */
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao = new UserDao(User.class);
        req.setCharacterEncoding("UTF-8");
        User user = new User();
        user.setFirstName("Петька!");
        //user.setFirstName(req.getParameter("first_name"));
        System.out.println(req.getParameter("first_name"));
        System.out.println(req.getParameter("last_name"));
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
        userDao.create(user);
        ///user.setBirthDate(new Date());
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
