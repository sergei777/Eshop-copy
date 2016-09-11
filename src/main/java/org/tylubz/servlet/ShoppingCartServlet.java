package org.tylubz.servlet;

import org.tylubz.entity.ShoppingCart;
import org.tylubz.entity.ShoppingUnit;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by Sergei on 10.09.2016.
 */
public class ShoppingCartServlet extends HttpServlet {

    private static ShoppingCart shoppingCart;

    @Override
    public void init() throws ServletException {
        shoppingCart = new ShoppingCart();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        add(req);
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }

    public void add(HttpServletRequest request){
        HttpSession session = request.getSession();
        shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
        System.out.println(request.getParameter("name"));
        if(shoppingCart != null){
            ShoppingUnit unit = new ShoppingUnit();
            unit.setName(request.getParameter("name"));
            unit.setPrice(Float.valueOf(request.getParameter("price")));
            unit.setAmount(Integer.valueOf(request.getParameter("amount")));
            shoppingCart.addUnit(unit);
            session.setAttribute("shoppingCart",shoppingCart);
            System.out.println("if-block");
        }
        else {
            System.out.println("else-block");
            ShoppingUnit unit = new ShoppingUnit();
            unit.setName(request.getParameter("name"));
            unit.setPrice(Float.valueOf(request.getParameter("price")));
            unit.setAmount(Integer.valueOf(request.getParameter("amount")));
            shoppingCart = new ShoppingCart();
            shoppingCart.addUnit(unit);
            session.setAttribute("shoppingCart",shoppingCart);
        }
    }

}
