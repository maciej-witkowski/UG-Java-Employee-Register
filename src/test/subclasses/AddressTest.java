package test.subclasses;

import main.subclasses.Address;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class AddressTest {
    private Address address;

    @Before
    public void setUp() {
        address = new Address("Stalowa", 12, 67, "Opole");
    }

    @Test
    public void testGetStreet() {
        Assertions.assertEquals("Stalowa", address.getStreet());
    }

    @Test
    public void testGetBuildingNumber() {
        Assertions.assertEquals(12, address.getBuildingNumber());
    }

    @Test
    public void testApartmentNumber() {
        Assertions.assertEquals(67, address.getApartmentNumber());
    }

    @Test
    public void testGetCity() {
        Assertions.assertEquals("Opole", address.getCity());
    }
}
