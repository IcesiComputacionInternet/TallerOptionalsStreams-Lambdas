package co.edu.icesi.functional;

import co.edu.icesi.model.IcesiUser;
import co.edu.icesi.model.SimpleName;

import java.util.*;
import java.util.function.Predicate;

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
        List<String[]> lastNames2 = icesiUsers.stream().filter(Objects::nonNull).map(IcesiUser::getLastName).map(j->j.split(" ")).toList();
        List<String> lastNames1 = lastNames2.stream().flatMap(Arrays::stream).toList();
        return  lastNames1.stream().sorted().distinct().toList();


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
        List<IcesiUser> filteredUsers = icesiUsers.stream().filter(Objects::nonNull).filter(user -> user.getAddress()!=null).filter(user-> user.getAddress().getStreet()==street).toList();
        return filteredUsers;
    }

    /**
     * given a list of IcesiUser's map the names to a SimpleName class.
     *  value = 0.5
     * @param icesiUsers icesiUsers a list of IcesiUser, can contain null values.
     * @return a list of SimpleName.
     */
    public List<SimpleName> mapToSimpleName(List<IcesiUser> icesiUsers) {

        List<SimpleName> names = icesiUsers.stream().filter(Objects::nonNull).map(user -> new SimpleName(user.getFirstName(), user.getLastName())).toList();
        return names;
    }


}
