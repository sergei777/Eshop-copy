package org.tylubz.servlet;

import org.tylubz.cart.ShoppingCart;
import org.tylubz.cart.ShoppingUnit;
import org.tylubz.dao.ProductDao;
import org.tylubz.dao.UserDao;
import org.tylubz.dao.exceptions.DaoStoreException;
import org.tylubz.entity.*;
import org.tylubz.service.GenericService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergei on 11.09.2016.
 */
public class MakeOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        req.setCharacterEncoding("UTF-8");
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
        String username = session.getAttribute("username").toString();
        createOrder(shoppingCart,username,req,resp);
        shoppingCart = new ShoppingCart();
        req.getSession().setAttribute("shoppingCart",shoppingCart);
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }

    public void createOrder(ShoppingCart shoppingCart,String username,HttpServletRequest req,HttpServletResponse resp){
        GenericService<OrderEntity,Integer> orderService = new GenericService<OrderEntity, Integer>(OrderEntity.class);
        UserDao userDao = new UserDao();
        List<ShoppingUnit> shoppingList = shoppingCart.getShoppingList();
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setDeliveryType(req.getParameter("delivery_type"));
        orderEntity.setPaymentType(req.getParameter("payment_type"));
        orderEntity.setOrderStatus(req.getParameter("order_status"));
        orderEntity.setPaymentStatus(req.getParameter("payment_status"));
        UserEntity entity = userDao.getEntityByUsername(username);
        orderEntity.setUser(entity);
        orderEntity.setAddressEntity(getAddressEntity(req));
        orderEntity.setProducts(getProductList(shoppingList));
        try {
            orderService.create(orderEntity);
            decrementProductAmount(shoppingList);
        } catch (DaoStoreException e) {
            resp.setStatus(500);
        }

    }

    private List<ProductEntity> getProductList(List<ShoppingUnit> shoppingList){
        GenericService<ProductEntity,Integer> productService = new GenericService<ProductEntity, Integer>(ProductEntity.class);
        List<ProductEntity> productList = new ArrayList<ProductEntity>();
        for(ShoppingUnit unit : shoppingList){
            productList.add(productService.read(unit.getId()));
        }
        return productList;
    }

    private AddressEntity getAddressEntity(HttpServletRequest request){
        AddressEntity entity = new AddressEntity();
        entity.setCountry(request.getParameter("country").toString());
        entity.setCity(request.getParameter("city").toString());
        entity.setPostcode(Integer.valueOf(request.getParameter("postcode")));
        entity.setStreetName(request.getParameter("street"));
        entity.setHouseNumber(Integer.valueOf(request.getParameter("house_number")));
        entity.setDoor(Integer.valueOf(request.getParameter("float_number")));
        return entity;
    }

    private void decrementProductAmount(List<ShoppingUnit> shoppingList) throws DaoStoreException {
        ProductDao productDao = new ProductDao();
        for(ShoppingUnit unit : shoppingList){
            productDao.decrementProductAmount(unit.getId());
        }
    }

}
