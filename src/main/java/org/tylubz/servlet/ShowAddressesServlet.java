package org.tylubz.servlet;

import org.tylubz.dao.GenericDaoJpaImpl;
import org.tylubz.entity.ClientAddress;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Sergei on 28.08.2016.
 */
public class ShowAddressesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDaoJpaImpl<ClientAddress,Integer> service = new GenericDaoJpaImpl<ClientAddress, Integer>(ClientAddress.class);
        ClientAddress ca = service.read(1);
        String clientAddressCountry =  ca.getCountry();
        req.setAttribute("clientAddressCountry",clientAddressCountry);
        String clientAddressCity =  ca.getCity();
        req.setAttribute("clientAddressCity",clientAddressCity);
        req.getRequestDispatcher("/products/products.jsp").forward(req, resp);
    }
}
