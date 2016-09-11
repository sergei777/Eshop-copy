package org.tylubz.dao;

import org.tylubz.entity.Product;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Sergei on 04.09.2016.
 */
public class ProductDao extends GenericDaoJpaImpl {
    public ProductDao(Class entity) {
        super(entity);
    }

    public List<Product> getAllProducts(){
        String queryString = "SELECT a FROM Product AS a";
        Query query = entityManager.createQuery(queryString);
        return (List<Product>) query.getResultList();
    }
}
