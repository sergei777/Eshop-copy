import org.tylubz.dao.ProductDao;
import org.tylubz.dao.UserDao;
import org.tylubz.entity.*;
import org.tylubz.service.GenericService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.Order;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergei on 20.08.2016.
 */
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("myapp");
        EntityManager em = emFactory.createEntityManager();

        AddressEntity entity = new AddressEntity();
        entity.setCity("NewYork");
        entity.setCountry("USA");
        entity.setPostcode(197232);
        entity.setStreetName("AvenueStreet");
        entity.setHouseNumber(34);
        entity.setDoor(20);

        OrderEntity entityOrder = new OrderEntity();
        //entityOrder.setId(5);
        entityOrder.setPaymentType("Карта");
        entityOrder.setDeliveryType("Почта");

        entityOrder.setAddressEntity(entity);
        UserEntity userEntity = em.find(UserEntity.class,9);
        entityOrder.setUser(userEntity);
        entityOrder.setAddressEntity(entity);
        em.getTransaction().begin();
        em.persist(entityOrder);
        em.getTransaction().commit();
        em.close();
        emFactory.close();
    }
}
