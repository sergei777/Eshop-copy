package org.tylubz.dao;

import org.tylubz.entity.OrderEntity;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Sergei on 12.09.2016.
 */
public class OrderDao extends GenericDaoJpaImpl {

    public OrderDao() {
        super(OrderEntity.class);
    }

    public List<OrderEntity> getAllOrderEntity(){
        String queryString = "SELECT a FROM OrderEntity a";
        Query query = entityManager.createQuery(queryString);
        return (List<OrderEntity>) query.getResultList();
    }
}
