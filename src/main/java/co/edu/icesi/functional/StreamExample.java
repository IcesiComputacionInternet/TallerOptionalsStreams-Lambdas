package co.edu.icesi.functional;

import co.edu.icesi.model.IcesiUser;
import co.edu.icesi.model.SimpleName;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
    public List<String> allDifferentLastNamesSorted(List<IcesiUser> icesiUsers) { // se puede hacer en una sola linea -0.3
        List<IcesiUser> notNull = icesiUsers.stream().filter(x-> x!=null).toList();
        List<String> list = notNull.stream().map(IcesiUser::getLastName).toList();
        List<List<String>>  AllLastNames = list.stream().map(x-> List.of(x.split(" "))).toList();
        List<String> flatMap = AllLastNames.stream().flatMap(Collection::stream).distinct().sorted().toList();

        return flatMap;
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
    public List<IcesiUser> filterUsersByStreet(List<IcesiUser> icesiUsers, String street) { // sepuede hacer en una sola linea -0.3
        List<IcesiUser> notNullUser = icesiUsers.stream().filter(x->x.getAddress()!=null).toList();
        List<IcesiUser> notNullAddress = notNullUser.stream().filter(x->x.getAddress().getStreet()!=null).toList();
        List<IcesiUser> users = notNullAddress.stream().filter(x->x.getAddress().getStreet().equals(street)).toList();

        return users;
    }

    /**
     * given a list of IcesiUser's map the names to a SimpleName class.
     *  value = 0.5
     * @param icesiUsers icesiUsers a list of IcesiUser, can contain null values.
     * @return a list of SimpleName.
     */
    public List<SimpleName> mapToSimpleName(List<IcesiUser> icesiUsers) { // despues de las 4 -0.5
        List<IcesiUser> notNull = icesiUsers.stream().filter(x->x!=null).toList();
        List<SimpleName> simpleNames = notNull.stream().map(x->new SimpleName(x.getFirstName(),x.getLastName())).toList();

        return simpleNames;
    }
}
