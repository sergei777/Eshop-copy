package org.tylubz.dao;

import org.tylubz.entity.OrderHasProductEntity;

import javax.persistence.Query;
import java.util.*;

/**
 * Created by Sergei on 15.09.2016.
 */
public class OrderHasProductDao extends GenericDaoJpaImpl {
    public OrderHasProductDao() {
        super(OrderHasProductEntity.class);
    }

    public Map<Integer,Long> getReverseOrderingCountProductList(){
        Map<Integer,Long> map = new LinkedHashMap<>();
        String queryStr = "SELECT DISTINCT e.productId, COUNT(e.productId) \n" +
                "FROM OrderHasProductEntity e \n" +
                "GROUP BY e.productId \n" +
                "ORDER BY COUNT(e.productId) DESC";
        Query query = entityManager.createQuery(queryStr);
        List<Object[]> result1 = query.getResultList();
        for(Object[] result : result1){
            Integer id = (Integer) result[0];
            Long amount =  (Long) result[1];
            map.put(id,amount);
        }
        return map;
    }

}
