package org.tylubz.servlet;

import org.tylubz.dao.impl.OrderDao;
import org.tylubz.dao.impl.UserDao;
import org.tylubz.dao.exceptions.DaoStoreException;
import org.tylubz.entity.OrderEntity;
import org.tylubz.entity.UserEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Making operations with orders in db
 *
 * @author Sergei
 */
public class OrderListServlet extends HttpServlet {
    /**
     * Checks the request parameters
     * and call method
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("getorderlistbyid") != null) {
            UserDao userDao = new UserDao();
            UserEntity userEntity = (UserEntity) userDao.read(Integer.valueOf(req.getParameter("getorderlistbyid")));
            req.setAttribute("orderList", userEntity.getOrders());
            resp.sendRedirect("/user/orderlist.jsp");
        } else {
            if (req.getParameter("orderStatusUpdate") != null) {
                updateOrderStatus(req.getParameter("orderStatusUpdate"), Integer.valueOf(req.getParameter("id")), resp);
                resp.sendRedirect("/admin/orderlist.jsp");
            } else {
                OrderDao orderDao = new OrderDao();
                req.setAttribute("orderList", orderDao.getAllOrderEntity());
                resp.sendRedirect("/admin/orderlist.jsp");
            }
        }
    }

    /**
     * Updates order status in db
     *
     * @param status status
     * @param id     of entity
     * @param resp   for setting status
     */
    public void updateOrderStatus(String status, int id, HttpServletResponse resp) {
        OrderDao orderDao = new OrderDao();
        OrderEntity orderEntity = (OrderEntity) orderDao.read(id);
        orderEntity.setOrderStatus(status);
        try {
            orderDao.update(orderEntity);
        } catch (DaoStoreException e) {
            resp.setStatus(500);
        }
    }
}
