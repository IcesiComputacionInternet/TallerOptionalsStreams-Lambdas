package co.edu.icesi.functional;

import co.edu.icesi.model.IcesiUser;
import co.edu.icesi.model.SimpleName;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StreamExample {

    /**
     * given a list of IcesiUser's get all the different lastnames if is a composed lastname each one of them
     * will count as a individual lastname. example "Prada Calderon" counts as "Prada" and "Calderon"
     * value = 1.0
     *
     * @param icesiUsers a list of IcesiUser, can contain null values.
     * @return a sorted list of different lastnames.
     */
    public List<String> allDifferentLastNamesSorted(List<IcesiUser> icesiUsers) {
        List<String> lastnames = icesiUsers.stream().filter(Objects::nonNull)
                .map(icesiUser -> icesiUser.getLastName())
                .flatMap(composedLastName -> Arrays.stream(composedLastName.split(" ")))
                .sorted().distinct().toList();

        return lastnames;
    }

    /**
     * given a list of IcesiUser's filter the list by the ones that match the street name with
     * the street in his IcesiAddress.
     * value 1.0
     *
     * @param icesiUsers a list of IcesiUser, can contain null values.
     * @param street     a non-null string indicating the street to filter
     * @return a list of IcesiUser with the matching IcesiUser street.
     */
    public List<IcesiUser> filterUsersByStreet(List<IcesiUser> icesiUsers, String street) {
        List<IcesiUser> matches = icesiUsers.stream().filter(Objects::nonNull)
                .filter(icesiUser -> Objects.nonNull(icesiUser.getAddress()) &&
                        Objects.nonNull(icesiUser.getAddress().getStreet()) &&
                        icesiUser.getAddress().getStreet().equals(street)).toList(); // y si usas optionals? -0.1
        return matches;
    }

    /**
     * given a list of IcesiUser's map the names to a SimpleName class.
     *  value = 0.5
     * @param icesiUsers icesiUsers a list of IcesiUser, can contain null values.
     * @return a list of SimpleName.
     */
    public List<SimpleName> mapToSimpleName(List<IcesiUser> icesiUsers) {
        return null;
    }


}
