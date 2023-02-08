package co.edu.icesi.functional;

import co.edu.icesi.model.IcesiUser;
import co.edu.icesi.model.SimpleName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {

    /**
     * given a list of IcesiUser's get all the different lastnames if is a composed
     * lastname each one of them
     * will count as a individual lastname. example "Prada Calderon" counts as
     * "Prada" and "Calderon"
     * value = 1.0
     *
     * @param icesiUsers a list of IcesiUser, can contain null values.
     * @return a sorted list of different lastnames.
     */
    public List<String> allDifferentLastNamesSorted(List<IcesiUser> icesiUsers) {
        List<String> newLastNames = icesiUsers.stream().filter(user -> user != null && user.getLastName() != null)
                .map(icesiUser -> icesiUser.getLastName())
                .flatMap(lastNames -> Arrays.stream(lastNames.split(" ")))
                .sorted().distinct().toList();

        return newLastNames;

    }

    /**
     * given a list of IcesiUser's filter the list by the ones that match the street
     * name with
     * the street in his IcesiAddress.
     * value 1.0
     *
     * @param icesiUsers a list of IcesiUser, can contain null values.
     * @param street     a non-null string indicating the street to filter
     * @return a list of IcesiUser with the matching IcesiUser street.
     */
    public List<IcesiUser> filterUsersByStreet(List<IcesiUser> icesiUsers, String street) {
        List<IcesiUser> s = icesiUsers.stream().filter(user -> user.getAddress() != null
                && user.getAddress().getStreet() != null && user.getAddress().getStreet().equals(street)).toList();
        return s;
    }

    /**
     * given a list of IcesiUser's map the names to a SimpleName class.
     * value = 0.5
     * 
     * @param icesiUsers icesiUsers a list of IcesiUser, can contain null values.
     * @return a list of SimpleName.
     */
    public List<SimpleName> mapToSimpleName(List<IcesiUser> icesiUsers) {
        List<String> names = icesiUsers.stream().filter(us -> us != null && us.getFirstName() != null)
                .map(IcesiUser::getFirstName).toList();
        List<String> lastNames = icesiUsers.stream().filter(us -> us != null && us.getLastName() != null)
                .map(IcesiUser::getLastName).toList();
        List<SimpleName> simple = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            simple.add(new SimpleName(names.get(i), lastNames.get(i)));

        }
        return simple;
        // List<SimpleName> simpeNames = Stream.concat(names.stream
    }
}
