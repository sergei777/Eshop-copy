package org.tylubz.dao.impl;

import org.tylubz.entity.OrderEntity;

import javax.persistence.Query;
import java.util.List;

/**
 * Dao for OrderEntity
 *
 * @author Sergei
 */
public class OrderDao extends GenericDaoJpaImpl {

    public OrderDao() {
        super(OrderEntity.class);
    }

    /**
     * Return list of all entities in db
     *
     * @return list of entities
     */
    public List<OrderEntity> getAllOrderEntity() {
        String queryString = "SELECT a FROM OrderEntity a";
        Query query = entityManager.createQuery(queryString);
        return (List<OrderEntity>) query.getResultList();
    }
}
