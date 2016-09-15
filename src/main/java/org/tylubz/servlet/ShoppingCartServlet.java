package org.tylubz.servlet;

import org.tylubz.cart.ShoppingCart;
import org.tylubz.cart.ShoppingUnit;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Class for making operations with
 * shopping cart
 */
public class ShoppingCartServlet extends HttpServlet {
    private ShoppingCart shoppingCart;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if("addItem".equals(req.getParameter("action"))) {
            addNewItem(req);
            req.getRequestDispatcher("/product-list?operation=getProductList").forward(req, resp);
        }
        if("removeItemById".equals(req.getParameter("action"))){
            removeShoppingUnitById(Integer.valueOf(req.getParameter("id")));
            req.getSession().setAttribute("shoppingCart",shoppingCart);
            req.getRequestDispatcher("/bucket.jsp").forward(req, resp);
        }
    }

    /**
     * add new item to shopping cart
     * @param request
     */
    public void addNewItem(HttpServletRequest request){
        HttpSession session = request.getSession();
        shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");;
        ShoppingUnit unit = createShoppingUnit(request);
        if(shoppingCart == null){
            shoppingCart = new ShoppingCart();
        }
        shoppingCart.addUnit(unit);
        session.setAttribute("shoppingCart",shoppingCart);
    }

    /**
     * Creates new shopping unit
     * @param request for extracting data
     * @return shopping unit
     */
    private ShoppingUnit createShoppingUnit(HttpServletRequest request){
        ShoppingUnit unit = new ShoppingUnit();
        unit.setName(request.getParameter("name"));
        unit.setPrice(Float.valueOf(request.getParameter("price")));
        unit.setAmount(Integer.valueOf(request.getParameter("amount")));
        unit.setId(Integer.valueOf(request.getParameter("id")));
        return unit;
    }

    /**
     * remove product from shopping cart
     * @param id for removing
     */
    private void removeShoppingUnitById(int id){
        shoppingCart.removeUnitById(id);
    }
}
