import org.tylubz.dao.GenericDao;
import org.tylubz.dao.GenericDaoJpaImpl;
import org.tylubz.entity.ClientAddress;

/**
 * Created by Sergei on 21.08.2016.
 */
public class New {
    public static void main(String[] args) {
        ClientAddress clientAddressEntity = new ClientAddress();
        GenericDao<ClientAddress,Integer> impl = new GenericDaoJpaImpl(ClientAddress.class);
        clientAddressEntity.setCity("NewYork");
        clientAddressEntity.setCountry("USA");
        clientAddressEntity.setPostcode(197232);
        clientAddressEntity.setStreetName("AvenueStreet");
        clientAddressEntity.setHouseNumber(34);
        clientAddressEntity.setDoor(20);
        impl.create(clientAddressEntity);
        //service.update(clientAddressEntity);
    }
}
