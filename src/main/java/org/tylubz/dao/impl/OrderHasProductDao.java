package org.tylubz.dao.impl;

import org.tylubz.entity.OrderHasProductEntity;

import javax.persistence.Query;
import java.util.*;

/**
 * Dao for OrderHasProduct entity
 *
 * @author Sergei
 */
public class OrderHasProductDao extends GenericDaoJpaImpl {
    public OrderHasProductDao() {
        super(OrderHasProductEntity.class);
    }

    /**
     * Returns amount of every product in order_has_product table
     * by reverse order
     *
     * @return map which consists of id product
     * and amount
     */
    public Map<Integer, Long> getReverseOrderingCountProductList() {
        Map<Integer, Long> map = new LinkedHashMap<>();
        String queryStr = "SELECT DISTINCT e.productId, COUNT(e.productId) \n" +
                "FROM OrderHasProductEntity e \n" +
                "GROUP BY e.productId \n" +
                "ORDER BY COUNT(e.productId) DESC";
        Query query = entityManager.createQuery(queryStr);
        List<Object[]> result1 = query.getResultList();
        for (Object[] result : result1) {
            Integer id = (Integer) result[0];
            Long amount = (Long) result[1];
            map.put(id, amount);
        }
        return map;
    }

}
