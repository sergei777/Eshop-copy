package org.tylubz.dao;

import org.tylubz.dao.exceptions.DaoStoreException;
import org.tylubz.entity.ProductEntity;

import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import java.util.List;

/**
 *
 * @author Sergei
 */
public class ProductDao extends GenericDaoJpaImpl {
    public ProductDao() {
        super(ProductEntity.class);
    }

    public List<ProductEntity> getAllProducts(){
        String queryString = "SELECT a FROM ProductEntity AS a";
        Query query = entityManager.createQuery(queryString);
        return (List<ProductEntity>) query.getResultList();
    }

    public List<ProductEntity> getProductsByCategory(String category){
        String queryString = "SELECT a FROM ProductEntity AS a WHERE a.category = :category";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("category",category);
        return (List<ProductEntity>) query.getResultList();
    }

    public List<ProductEntity> getProductsByPriceRange(Float minPrice,Float maxPrice){
        String queryString = "SELECT a FROM ProductEntity AS a WHERE a.price between :minPrice and :maxPrice";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("minPrice",minPrice);
        query.setParameter("maxPrice",maxPrice);
        return (List<ProductEntity>) query.getResultList();
    }

    public void decrementProductAmount(Integer id) throws DaoStoreException {
        EntityTransaction trx = getEntityManager().getTransaction();
        try{
            trx.begin();
            ProductEntity entity = getEntityManager().find(ProductEntity.class,id);
            int amount = entity.getAmount();
            entity.setAmount(--amount);
            trx.commit();
        }
        catch (PersistenceException ex){
            throw new DaoStoreException(ex);
        }
        finally {
            if(trx.isActive()) trx.rollback();
        }
    }
}
