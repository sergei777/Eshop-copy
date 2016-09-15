package org.tylubz.servlet;

import org.tylubz.dao.impl.OrderHasProductDao;
import org.tylubz.dao.impl.ProductDao;
import org.tylubz.entity.ProductEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Class for sending statistic
 *
 * @author Sergei
 */
public class StatisticsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("map", getReverseOrderingCountProductList());
    }

    /**
     * Return the amount of every product
     *
     * @return map which consists of product name
     * and amount
     */
    public Map<String, Long> getReverseOrderingCountProductList() {
        OrderHasProductDao orderHasProductDao = new OrderHasProductDao();
        Map<Integer, Long> map = orderHasProductDao.getReverseOrderingCountProductList();
        ProductDao productDao = new ProductDao();
        Map<String, Long> productMap = new LinkedHashMap<>();
        for (Integer key : map.keySet()) {
            ProductEntity entity = (ProductEntity) productDao.read(key);
            productMap.put(entity.getName(), map.get(key));
        }
        return productMap;
    }
}
