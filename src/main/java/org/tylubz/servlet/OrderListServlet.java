package org.tylubz.servlet;

import org.tylubz.dao.OrderDao;
import org.tylubz.entity.OrderEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Sergei on 12.09.2016.
 */
public class OrderListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("orderStatusUpdate")!=null){
            updateEntity(req.getParameter("orderStatusUpdate"),Integer.valueOf(req.getParameter("id")));
        }
        else {
            OrderDao orderDao = new OrderDao();
            req.setAttribute("orderList", orderDao.getAllOrderEntity());
        }
        resp.sendRedirect("/admin/orderlist.jsp");
    }

    public void updateEntity(String status,int id){
        OrderDao orderDao = new OrderDao();
        OrderEntity orderEntity = (OrderEntity) orderDao.read(id);
        orderEntity.setOrderStatus(status);
        orderDao.update(orderEntity);
    }
}
