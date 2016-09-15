package org.tylubz.servlet;

import org.tylubz.dao.OrderHasProductDao;
import org.tylubz.dao.ProductDao;
import org.tylubz.entity.OrderHasProductEntity;
import org.tylubz.entity.ProductEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Sergei on 15.09.2016.
 */
public class StatisticServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("map",getReverseOrderingCountProductList());
    }
    public Map<String,Long> getReverseOrderingCountProductList(){
        OrderHasProductDao orderHasProductDao = new OrderHasProductDao();
        Map<Integer,Long> map = orderHasProductDao.getReverseOrderingCountProductList();
        ProductDao productDao = new ProductDao();
        Map<String,Long> productMap = new LinkedHashMap<>();
        for(Integer key : map.keySet()){
            ProductEntity entity = (ProductEntity) productDao.read(key);
            productMap.put(entity.getName(),map.get(key));
        }
        return productMap;
    }
}
