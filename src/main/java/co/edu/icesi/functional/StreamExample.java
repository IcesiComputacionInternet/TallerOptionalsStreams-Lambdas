package co.edu.icesi.functional;

import co.edu.icesi.model.IcesiAddress;
import co.edu.icesi.model.IcesiUser;
import co.edu.icesi.model.SimpleName;
import java.util.*;
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
    public List<String> allDifferentLastNamesSorted(List<IcesiUser> icesiUsers) { // solo es necesario un call al collectors -0.2
        Set<String> lastNames = icesiUsers.stream()
                .flatMap(user -> Arrays.stream(user.getLastName().split(" ")))
                .collect(Collectors.toSet());
        return lastNames.stream()
                .sorted(String::compareToIgnoreCase)
                .collect(Collectors.toList());
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
        return icesiUsers.stream()
                .filter(user -> Optional.ofNullable(user).map(IcesiUser::getAddress).map(IcesiAddress::getStreet).filter(street::equals).isPresent())
                .toList();
    }

    /**
     * given a list of IcesiUser's map the names to a SimpleName class.
     *  value = 0.5
     * @param icesiUsers icesiUsers a list of IcesiUser, can contain null values.
     * @return a list of SimpleName.
     */
    public List<SimpleName> mapToSimpleName(List<IcesiUser> icesiUsers) { // despues de las 4pm -0.5
        return icesiUsers.stream()
                .map(user -> Optional.ofNullable(user).map(u -> new SimpleName(u.getFirstName(), u.getLastName())))
                .flatMap(Optional::stream)
                .collect(Collectors.toList());
    }

}
