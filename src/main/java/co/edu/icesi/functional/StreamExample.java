package co.edu.icesi.functional;

import co.edu.icesi.model.IcesiUser;
import co.edu.icesi.model.SimpleName;

import java.util.*;
import java.util.stream.Stream;

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

        List<String> splitLastNames = icesiUsers.stream().filter(user -> user != null).map(IcesiUser::getLastName).toList();

        List<String> lastNames = splitLastNames.stream().map(lastName -> List.of(lastName.split(" "))).flatMap(Collection::stream).distinct().sorted().toList();

        return lastNames;
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

        List<IcesiUser> usersVerified = icesiUsers.stream().filter(user -> userNotNull(user) && verifyStreet(user, street)).toList();

        return usersVerified;
    }

    public boolean userNotNull(IcesiUser user){

        return user != null;
    }

    public boolean verifyStreet(IcesiUser user, String street){

        return user.getAddress() != null && street.equalsIgnoreCase(user.getAddress().getStreet());
    }

    /**
     * given a list of IcesiUser's map the names to a SimpleName class.
     *  value = 0.5
     * @param icesiUsers icesiUsers a list of IcesiUser, can contain null values.
     * @return a list of SimpleName.
     */
    public List<SimpleName> mapToSimpleName(List<IcesiUser> icesiUsers) {

        List<String> names = icesiUsers.stream().filter(user -> user != null).map(IcesiUser::getFirstName).toList();
        List<String> lastNames = icesiUsers.stream().filter(user -> user != null).map(IcesiUser::getLastName).toList();
        List<SimpleName> simpleNames = new ArrayList<>();

        for (int i = 0; i < names.size(); i++){
            SimpleName simpleName = new SimpleName(names.get(i), lastNames.get(i));
            simpleNames.add(simpleName);
        }

        return simpleNames;
    }


}
