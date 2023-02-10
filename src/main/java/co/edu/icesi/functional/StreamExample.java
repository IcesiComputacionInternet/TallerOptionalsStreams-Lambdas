package co.edu.icesi.functional;

import co.edu.icesi.model.IcesiUser;
import co.edu.icesi.model.SimpleName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamExample {

    /**
     * given a list of IcesiUser's get all the different lastnames if is a composed lastname each one of them
     * will count as a individual lastname. example "Prada Calderon" counts as "Prada" and "Calderon"
     * value = 1.0
     *
     * @param icesiUsers a list of IcesiUser, can contain null values.
     * @return a sorted list of different lastnames.
     */
    public List<String> allDifferentLastNamesSorted(List<IcesiUser> icesiUsers) { // -0.3 multiple uso de .toList()
        icesiUsers = icesiUsers.stream().filter(x->x!=null).toList();
        List<String> lastnames = icesiUsers.stream().map(IcesiUser::getLastName).toList();
        List<String[]> horror = lastnames.stream().map(x->x.split(" ")).toList();
        List<String> result = horror.stream().flatMap(Arrays::stream).toList();
        List<String> filtered = result.stream().distinct().toList();
        filtered = filtered.stream().sorted().toList();
        return filtered;
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
    public List<IcesiUser> filterUsersByStreet(List<IcesiUser> icesiUsers, String street) { // -0.8
        icesiUsers = icesiUsers.stream().filter(x->x.getAddress() != null).toList(); // no filtras los nulls de user
        List<IcesiUser> filtered = icesiUsers.stream().filter(x->x.getAddress().getStreet()==street).toList(); // uso de == en vez de .equals

        return filtered;
    }

    /**
     * given a list of IcesiUser's map the names to a SimpleName class.
     *  value = 0.5
     * @param icesiUsers icesiUsers a list of IcesiUser, can contain null values.
     * @return a list of SimpleName.
     */
    public List<SimpleName> mapToSimpleName(List<IcesiUser> icesiUsers) { // despues de las 4pm -0.5
        icesiUsers = icesiUsers.stream().filter(x->x != null).toList();
        List<SimpleName> simpleNames = icesiUsers.stream().map(x->new SimpleName(x.getFirstName(), x.getLastName())).toList();
        return simpleNames;
    }


}
