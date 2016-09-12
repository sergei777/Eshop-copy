package org.tylubz.servlet;

import org.tylubz.dao.ProductDao;
import org.tylubz.entity.ProductEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Sergei on 12.09.2016.
 */
public class ProductListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("updateItem")!=null){
            updateItem(req,resp);
            resp.sendRedirect("/admin/productitem.jsp");
        }
        else{
            ProductDao productDao = new ProductDao();
            List<ProductEntity> list = productDao.getAllProducts();
            req.setAttribute("productList", list);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        ProductDao productDao = new ProductDao();
        ProductEntity productEntity = (ProductEntity) productDao.read(Integer.valueOf(req.getParameter("id")));
        productEntity.setAmount(Integer.valueOf(req.getParameter("amount")));
        productEntity.setPrice(Double.valueOf(req.getParameter("price")));
        productEntity.setName(req.getParameter("name"));
        productEntity.setCategory(req.getParameter("category"));
        productEntity.setWeight(Double.valueOf(req.getParameter("weight")));
        productEntity.setVolume(req.getParameter("volume"));
        productEntity.setImagePath(req.getParameter("img_path"));
        productDao.update(productEntity);
        req.setAttribute("productItem",productEntity);

        //resp.setContentType("text/plain");
        //resp.getWriter().print("{success: true}");
    }

    public void updateItem(HttpServletRequest req,HttpServletResponse resp){
        ProductDao productDao = new ProductDao();
        ProductEntity productEntity = (ProductEntity) productDao.read(Integer.valueOf(req.getParameter("id")));
        req.setAttribute("productItem",productEntity);
    }
}
