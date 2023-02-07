package co.edu.icesi.functional;

import co.edu.icesi.model.IcesiAddress;
import co.edu.icesi.model.IcesiUser;
import co.edu.icesi.model.SimpleName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamTest {


    private final StreamExample streamExample = new StreamExample();


    @Test
    public void testAllDifferentLastNamesSortedNoNullValues() {
        List<IcesiUser> icesiUsers = new ArrayList<>(Arrays.asList(
                new IcesiUser("John", "Doe"),
                new IcesiUser("Jane", "Doe"),
                new IcesiUser("Jim", "Smith")
        ));

        List<String> result = streamExample.allDifferentLastNamesSorted(icesiUsers);

        assertEquals(2, result.size());
        assertEquals("Doe", result.get(0));
        assertEquals("Smith", result.get(1));
    }

    @Test
    public void testAllDifferentLastNamesSortedNoNullValuesAndComposed() {
        List<IcesiUser> icesiUsers = new ArrayList<>(Arrays.asList(
                new IcesiUser("John", "Doe Smith"),
                new IcesiUser("Jane", "Doe"),
                new IcesiUser("Jim", "Smith")
        ));

        List<String> result = streamExample.allDifferentLastNamesSorted(icesiUsers);

        assertEquals(2, result.size());
        assertEquals("Doe", result.get(0));
        assertEquals("Smith", result.get(1));
    }

    @Test
    public void testAllDifferentLastNamesSortedWithNullValues() {
        List<IcesiUser> icesiUsers = new ArrayList<>(Arrays.asList(
                new IcesiUser("John", "Doe"),
                null,
                new IcesiUser("Jim", "Smith")
        ));

        List<String> result = streamExample.allDifferentLastNamesSorted(icesiUsers);

        assertEquals(2, result.size());
        assertEquals("Doe", result.get(0));
        assertEquals("Smith", result.get(1));
    }

    @Test
    public void testAllDifferentLastNamesSortedMultiwordLastNames() {
        List<IcesiUser> icesiUsers = new ArrayList<>(Arrays.asList(
                new IcesiUser("John", "Doe"),
                new IcesiUser("Jane", "Van Der Doe"),
                new IcesiUser("Jim", "Smith")
        ));

        List<String> result = streamExample.allDifferentLastNamesSorted(icesiUsers);

        assertEquals(4, result.size());
        assertEquals("Der", result.get(0));
        assertEquals("Doe", result.get(1));
        assertEquals("Smith", result.get(2));
        assertEquals("Van", result.get(3));
    }

    @Test
    public void testFilterUsersByStreetNoMatchingAddress() {
        List<IcesiUser> icesiUsers = new ArrayList<>(Arrays.asList(
                new IcesiUser("John", "Doe", new IcesiAddress("First Ave", "123")),
                new IcesiUser("Jane", "Doe", new IcesiAddress("Second Ave", "123")),
                new IcesiUser("Jim", "Smith", new IcesiAddress("Third Ave", "123"))
        ));

        List<IcesiUser> result = streamExample.filterUsersByStreet(icesiUsers, "Main St");

        assertEquals(0, result.size());
    }

    @Test
    public void testFilterUsersByStreetWithMatchingAddress() {
        List<IcesiUser> icesiUsers = new ArrayList<>(Arrays.asList(
                new IcesiUser("John", "Doe", new IcesiAddress("Main St", "123")),
                new IcesiUser("Jane", "Doe", new IcesiAddress("Second Ave", "123")),
                new IcesiUser("Jim", "Smith", new IcesiAddress("Main St", "123"))
        ));

        List<IcesiUser> result = streamExample.filterUsersByStreet(icesiUsers, "Main St");

        assertEquals(2, result.size());
        assertEquals("John", result.get(0).getFirstName());
        assertEquals("Jim", result.get(1).getFirstName());
    }

    @Test
    public void testFilterUsersByStreetNullAddress() {
        List<IcesiUser> icesiUsers = new ArrayList<>(Arrays.asList(
                new IcesiUser("John", "Doe", new IcesiAddress("Main St", "123")),
                new IcesiUser("Jane", "Doe", null),
                new IcesiUser("Jim", "Smith", new IcesiAddress("Main St", "123"))
        ));

        List<IcesiUser> result = streamExample.filterUsersByStreet(icesiUsers, "Main St");

        assertEquals(2, result.size());
        assertEquals("John", result.get(0).getFirstName());
        assertEquals("Jim", result.get(1).getFirstName());
    }

    @Test
    public void testFilterUsersByStreetNullStreet() {
        List<IcesiUser> icesiUsers = new ArrayList<>(Arrays.asList(
                new IcesiUser("John", "Doe", new IcesiAddress("Main St", "123")),
                new IcesiUser("Jane", "Doe", new IcesiAddress(null, "123")),
                new IcesiUser("Jim", "Smith", new IcesiAddress("Main St", "123"))
        ));

        List<IcesiUser> result = streamExample.filterUsersByStreet(icesiUsers, "Main St");

        assertEquals(2, result.size());
        assertEquals("John", result.get(0).getFirstName());
        assertEquals("Jim", result.get(1).getFirstName());
    }

    @Test
    public void  testMapIcesiUsersToSimpleName(){
        List<IcesiUser> icesiUsers = List.of(
                new IcesiUser("John", "Doe"),
                new IcesiUser("Jane", "Doe"),
                new IcesiUser("Jim", "Smith")
        );

        List<SimpleName> actual = streamExample.mapToSimpleName(icesiUsers);

        List<SimpleName> simpleNames = List.of(
                new SimpleName("John", "Doe"),
                new SimpleName("Jane", "Doe"),
                new SimpleName("Jim", "Smith")
        );

        assertEquals(simpleNames, actual);

    }

    @Test
    public void  testMapIcesiUsersToSimpleNameWithNullValues(){
        List<IcesiUser> icesiUsers = new ArrayList<>(Arrays.asList(
                new IcesiUser("John", "Doe"),
                new IcesiUser("Jane", "Doe"),
                new IcesiUser("Jim", "Smith"),
                null
        ));

        List<SimpleName> actual = streamExample.mapToSimpleName(icesiUsers);

        List<SimpleName> simpleNames = List.of(
                new SimpleName("John", "Doe"),
                new SimpleName("Jane", "Doe"),
                new SimpleName("Jim", "Smith")
        );

        assertEquals(simpleNames, actual);

    }

}
