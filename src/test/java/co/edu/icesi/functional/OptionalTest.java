package co.edu.icesi.functional;

import co.edu.icesi.model.IcesiAddress;
import co.edu.icesi.model.IcesiUser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OptionalTest {

    private final OptionalExample optionalExample = new OptionalExample();

    @Test
    public void testGetStreetFromUserSuccess() {
        IcesiUser icesiUser = defaultIcesiUser();
        String expected = icesiUser.getAddress().getStreet();
        String result = optionalExample.obtainUserStreet(icesiUser);
        assertEquals(expected, result);
    }

    @Test
    public void testGetStreetFromNullUser() {
        assertThrows(RuntimeException.class, () -> optionalExample.obtainUserStreet(null), "Couldn't get the street");
    }

    @Test
    public void testGetStreetFromUserWithNullStreet() {
        IcesiUser icesiUser = defaultIcesiUser();
        icesiUser.getAddress().setStreet(null);
        assertThrows(RuntimeException.class, () -> optionalExample.obtainUserStreet(icesiUser), "Couldn't get the street");
    }

    @Test
    public void testGetDescriptionSuccess() {
        IcesiUser icesiUser = defaultIcesiUser();
        String expected = icesiUser.getAddress().getDescription();
        String result = optionalExample.obtainUserDescription(icesiUser);

        assertEquals(expected, result);
    }

    @Test
    public void testGetDescriptionDefaultForNullUser() {
        String expected = "default description";
        String result = optionalExample.obtainUserDescription(null);
        assertEquals(expected, result);
    }

    @Test
    public void testGetDescriptionDefaultForNullDescription() {
        IcesiUser icesiUser = defaultIcesiUser();
        icesiUser.getAddress().setDescription(null);
        String expected = "default description";
        String result = optionalExample.obtainUserDescription(icesiUser);
        assertEquals(expected, result);
    }


    private IcesiUser defaultIcesiUser() {
        IcesiAddress icesiAddress = new IcesiAddress();
        icesiAddress.setDescription("Random description");
        icesiAddress.setStreet("Avenida siempre viva");
        icesiAddress.setNumber("123");
        IcesiUser icesiUser = new IcesiUser();
        icesiUser.setActive(true);
        icesiUser.setFirstName("John");
        icesiUser.setLastName("Doe");
        icesiUser.setSalary(1000L);
        icesiUser.setAddress(icesiAddress);
        return icesiUser;
    }


}
