package org.tylubz.servlet;

import org.tylubz.dao.ProductDao;
import org.tylubz.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Sergei on 04.09.2016.
 */
public class ShowProductsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDao productDao = new ProductDao(ProductDao.class);
        List<Product> products = productDao.getAllProducts();
        req.getSession().setAttribute("products", products);
        req.getRequestDispatcher("/showproducts.jsp").forward(req,resp);
    }
}
