package org.tylubz.servlet;

import org.tylubz.dao.ProductDao;
import org.tylubz.dao.exceptions.DaoStoreException;
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
public class ProductOperationsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if("getItemById".equals(req.getParameter("operation"))) {
            getItemById(req);
            resp.sendRedirect("/admin/productitem.jsp");
        }
        if("getProductList".equals(req.getParameter("operation"))){
            req.setAttribute("productList", getProductList());
            req.getRequestDispatcher("/products.jsp").forward(req,resp);
        }
        if("updateProductsByPriceRange".equals(req.getParameter("operation"))) {
            Float minPrice = Float.parseFloat(req.getParameter("minPrice"));
            Float maxPrice = Float.parseFloat(req.getParameter("maxPrice"));
            List<ProductEntity> list = getProductsByPriceRange(minPrice,maxPrice);
            req.setAttribute("productList",list);
            req.getRequestDispatcher("/products.jsp").forward(req,resp);
            for(ProductEntity pe : list){
                System.out.println(pe.getName());
            }
            //resp.setStatus(200);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        updateItem(req,resp);
    }

    public void getItemById(HttpServletRequest req){
        ProductDao productDao = new ProductDao();
        ProductEntity productEntity = (ProductEntity) productDao.read(Integer.valueOf(req.getParameter("id")));
        req.setAttribute("productItem",productEntity);
    }

    public List<ProductEntity> getProductList(){
        return new ProductDao().getAllProducts();
    }

    public void updateItem(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        ProductDao productDao = new ProductDao();
        ProductEntity productEntity = (ProductEntity) productDao.read(Integer.valueOf(req.getParameter("id")));
        productEntity.setAmount(Integer.valueOf(req.getParameter("amount")));
        productEntity.setPrice(Float.valueOf(req.getParameter("price")));
        productEntity.setName(req.getParameter("name"));
        productEntity.setCategory(req.getParameter("category"));
        productEntity.setWeight(Float.valueOf(req.getParameter("weight")));
        productEntity.setVolume(req.getParameter("volume"));
        productEntity.setImagePath(req.getParameter("img_path"));
        try {
            productDao.update(productEntity);
        } catch (DaoStoreException e) {
            resp.setStatus(500);
        }
        req.setAttribute("productItem",productEntity);
        resp.setStatus(200);
    }

    public List<ProductEntity> getProductsByPriceRange(Float minPrice,Float maxPrice){
        ProductDao productDao = new ProductDao();
        return productDao.getProductsByPriceRange(minPrice,maxPrice);
    }
}