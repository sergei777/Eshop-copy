import org.tylubz.dao.GenericDao;
import org.tylubz.dao.GenericDaoJpaImpl;
import org.tylubz.entity.AddressEntity;

/**
 * Created by Sergei on 21.08.2016.
 */
public class New {
    public static void main(String[] args) {
        AddressEntity clientAddressEntityEntity = new AddressEntity();
        GenericDao<AddressEntity,Integer> impl = new GenericDaoJpaImpl(AddressEntity.class);
        clientAddressEntityEntity.setCity("NewYork");
        clientAddressEntityEntity.setCountry("USA");
        clientAddressEntityEntity.setPostcode(197232);
        clientAddressEntityEntity.setStreetName("AvenueStreet");
        clientAddressEntityEntity.setHouseNumber(34);
        clientAddressEntityEntity.setDoor(20);
        impl.create(clientAddressEntityEntity);
        //service.update(clientAddressEntity);
    }
}
