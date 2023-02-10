package co.edu.icesi.functional;

import co.edu.icesi.model.IcesiAddress;
import co.edu.icesi.model.IcesiUser;
import co.edu.icesi.model.SimpleName;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collector;
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
        return icesiUsers.stream().filter(Objects::nonNull).toList().stream().map(IcesiUser::getLastName).flatMap(x-> Arrays.stream(x.split(" "))).distinct().sorted().toList(); //dos veces to list? -0.1
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
    public List<IcesiUser> filterUsersByStreet(List<IcesiUser> icesiUsers, String street) { // ojo con las lineas tan largas
        return icesiUsers.stream().filter(Objects::nonNull).toList().stream().filter(x -> Optional.ofNullable(x.getAddress()).isPresent())
                .filter(x -> Optional.ofNullable(x.getAddress().getStreet()).isPresent()).filter(x -> x.getAddress().getStreet().equals(street)).toList(); // Simplificar todos los filter -0.3
    }   



    /**
     * given a list of IcesiUser's map the names to a SimpleName class.
     *  value = 0.5
     * @param icesiUsers icesiUsers a list of IcesiUser, can contain null values.
     * @return a list of SimpleName.
     */
    public List<SimpleName> mapToSimpleName(List<IcesiUser> icesiUsers) { // -0.5 por entregar despues de las 4
      List<SimpleName> simpleName = icesiUsers.stream().filter(Objects::nonNull).map((x) -> new SimpleName(x.getFirstName(), x.getLastName())).toList();
        return simpleName;
    }

}
