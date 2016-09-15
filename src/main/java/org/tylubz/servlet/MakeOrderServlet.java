package org.tylubz.servlet;

import org.tylubz.cart.ShoppingCart;
import org.tylubz.cart.ShoppingUnit;
import org.tylubz.dao.interfaces.GenericDao;
import org.tylubz.dao.impl.GenericDaoJpaImpl;
import org.tylubz.dao.impl.ProductDao;
import org.tylubz.dao.impl.UserDao;
import org.tylubz.dao.exceptions.DaoStoreException;
import org.tylubz.entity.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * creates new order in db
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
        createOrder(shoppingCart, username, req, resp);
        shoppingCart = new ShoppingCart();
        req.getSession().setAttribute("shoppingCart", shoppingCart);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    /**
     * create new Order in db
     *
     * @param shoppingCart list of products
     * @param username     name of user
     * @param req          for extracting data
     * @param resp         for setting status
     */
    public void createOrder(ShoppingCart shoppingCart, String username, HttpServletRequest req, HttpServletResponse resp) {
        GenericDao<OrderEntity, Integer> orderService = new GenericDaoJpaImpl<OrderEntity, Integer>(OrderEntity.class);
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
        try {
            orderEntity.setProducts(getProductList(shoppingList));
            orderService.create(orderEntity);
            decrementProductAmount(shoppingList);
        } catch (DaoStoreException e) {
            resp.setStatus(500);
        }

    }

    /**
     * @param shoppingList
     * @return
     * @throws DaoStoreException
     */
    private List<ProductEntity> getProductList(List<ShoppingUnit> shoppingList) throws DaoStoreException {
        GenericDao<ProductEntity, Integer> productDao = new GenericDaoJpaImpl<>(ProductEntity.class);
        List<ProductEntity> productList = new ArrayList<ProductEntity>();
        for (ShoppingUnit unit : shoppingList) {
            productList.add(productDao.read(unit.getId()));
        }
        return productList;
    }

    /**
     * return new AddressEntity
     *
     * @param request
     * @return
     */
    private AddressEntity getAddressEntity(HttpServletRequest request) {
        AddressEntity entity = new AddressEntity();
        entity.setCountry(request.getParameter("country").toString());
        entity.setCity(request.getParameter("city").toString());
        entity.setPostcode(Integer.valueOf(request.getParameter("postcode")));
        entity.setStreetName(request.getParameter("street"));
        entity.setHouseNumber(Integer.valueOf(request.getParameter("house_number")));
        entity.setDoor(Integer.valueOf(request.getParameter("float_number")));
        return entity;
    }

    /**
     * decrement product amount
     * when order creates
     *
     * @param shoppingList list of products
     * @throws DaoStoreException
     */
    private void decrementProductAmount(List<ShoppingUnit> shoppingList) throws DaoStoreException {
        ProductDao productDao = new ProductDao();
        for (ShoppingUnit unit : shoppingList) {
            productDao.decrementProductAmount(unit.getId());
        }
    }

}
