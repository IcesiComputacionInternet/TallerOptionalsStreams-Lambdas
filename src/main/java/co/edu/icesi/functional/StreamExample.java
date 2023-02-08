package co.edu.icesi.functional;

import co.edu.icesi.model.IcesiUser;
import co.edu.icesi.model.SimpleName;

import java.util.*;
import java.util.function.Predicate;
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
        List<String> lastnames = icesiUsers.stream().filter(Objects::nonNull).map(IcesiUser::getLastName).distinct().toList();
        List<String> dLastNames = new ArrayList<>();
        for(int i = 0; i<lastnames.size(); i++) { // Aquí no usamos for's -0.5
            dLastNames.addAll(List.of((lastnames.get(i).split(" "))));
        }
        return dLastNames.stream().distinct().sorted().toList();
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
        return icesiUsers.stream().filter(x->(x.getAddress() != null)&&(x.getAddress().getStreet() !=null)).filter(x -> x.getAddress().getStreet().equals(street)).toList(); // para que existen los optionals? -0.5
    }

    /**
     * given a list of IcesiUser's map the names to a SimpleName class.
     *  value = 0.5
     * @param icesiUsers icesiUsers a list of IcesiUser, can contain null values.
     * @return a list of SimpleName.
     */
    public List<SimpleName> mapToSimpleName(List<IcesiUser> icesiUsers) {
        return icesiUsers.stream().filter(Objects::nonNull).map(x -> new SimpleName(x.getFirstName(),x.getLastName())).toList(); // -0.5 por entregar despues de las 4:00 pm
    }


}
