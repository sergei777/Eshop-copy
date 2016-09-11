import org.tylubz.entity.ClientAddress;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Sergei on 20.08.2016.
 */
public class Main {
    public static void main(String[] args) {
        ClientAddress entity = new ClientAddress();
        entity.setCity("NewYork");
        entity.setCountry("USA");
        entity.setPostcode(197232);
        entity.setStreetName("AvenueStreet");
        entity.setHouseNumber(34);
        entity.setDoor(20);

        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("myapp");
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();

        em.close();
    }
}
