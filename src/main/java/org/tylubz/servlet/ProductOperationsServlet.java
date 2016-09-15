package org.tylubz.servlet;

import org.tylubz.dao.impl.ProductDao;
import org.tylubz.dao.exceptions.DaoStoreException;
import org.tylubz.entity.ProductEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Making operation with products in db
 *
 * @author Sergei
 */
public class ProductOperationsServlet extends HttpServlet {
    /**
     * Checks the request parameters
     * and call method
     *
     * @param req  for extracting data
     * @param resp for setting url
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("getItemById".equals(req.getParameter("operation"))) {
            getItemById(req);
            resp.sendRedirect("/admin/productitem.jsp");
        }
        if ("getProductList".equals(req.getParameter("operation"))) {
            req.setAttribute("productList", getProductList());
            if ("admin".equals(req.getParameter("userType"))) {
                resp.sendRedirect("admin/productlist.jsp");
            } else {
                req.getRequestDispatcher("/products.jsp").forward(req, resp);
            }
        }
        if ("updateProductsByPriceRange".equals(req.getParameter("operation"))) {
            Float minPrice = Float.parseFloat(req.getParameter("minPrice"));
            Float maxPrice = Float.parseFloat(req.getParameter("maxPrice"));
            List<ProductEntity> list = getProductsByPriceRange(minPrice, maxPrice);
            req.setAttribute("productList", list);
            req.getRequestDispatcher("/products.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        updateItem(req, resp);
    }

    /**
     * return product by id
     *
     * @param req for extracting data
     */
    public void getItemById(HttpServletRequest req) {
        ProductDao productDao = new ProductDao();
        ProductEntity productEntity = (ProductEntity) productDao.read(Integer.valueOf(req.getParameter("id")));
        req.setAttribute("productItem", productEntity);
    }

    /**
     * return list of all products
     *
     * @return list of products
     */
    public List<ProductEntity> getProductList() {
        return new ProductDao().getAllProducts();
    }

    public void updateItem(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        ProductDao productDao = new ProductDao();
        ProductEntity productEntity = (ProductEntity) productDao.read(Integer.valueOf(req.getParameter("id")));
        if (productEntity == null) {
            productEntity = new ProductEntity();
        }
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
        req.setAttribute("productItem", productEntity);
        resp.setStatus(200);
    }

    /**
     * return list of entitites by
     * range
     *
     * @param minPrice min range value
     * @param maxPrice max range value
     * @return
     */
    public List<ProductEntity> getProductsByPriceRange(Float minPrice, Float maxPrice) {
        ProductDao productDao = new ProductDao();
        return productDao.getProductsByPriceRange(minPrice, maxPrice);
    }
}
