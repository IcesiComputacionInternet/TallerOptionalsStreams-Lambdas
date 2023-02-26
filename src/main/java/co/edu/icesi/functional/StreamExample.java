package co.edu.icesi.functional;

import co.edu.icesi.model.IcesiAddress;
import co.edu.icesi.model.IcesiUser;
import co.edu.icesi.model.SimpleName;

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
    public List<String> allDifferentLastNamesSorted(List<IcesiUser> icesiUsers) { // -0.2
        //Eliminación de toList redundantes
        List<String> sortedList = icesiUsers.stream().filter(x -> x!=null && x.getLastName()!=null)
                .map(IcesiUser::getLastName).flatMap(lastName -> Arrays.stream(lastName.split(" ")))
                .sorted().distinct().toList(); // muchos to list
        return sortedList;
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
    public List<IcesiUser> filterUsersByStreet(List<IcesiUser> icesiUsers, String street) { // uso de == en vez .equals -0.8
        //Implementación de .equalsIgnoreCase()
        List<IcesiUser> filteredUsers = icesiUsers.stream()
                .filter(IcesiUser -> IcesiUser!=null && IcesiUser.getAddress()!=null && IcesiUser.getAddress().getStreet()!=null)
                .filter(IcesiUser -> IcesiUser.getAddress().getStreet().equalsIgnoreCase(street)).toList();
        return filteredUsers;
    }

    /**
     * given a list of IcesiUser's map the names to a SimpleName class.
     *  value = 0.5
     * @param icesiUsers icesiUsers a list of IcesiUser, can contain null values.
     * @return a list of SimpleName.
     */
    public List<SimpleName> mapToSimpleName(List<IcesiUser> icesiUsers) { // despues de las 4 -0.5
        //Uso de 1 solo toList
        return icesiUsers.stream().filter(x -> x!=null && x.getFirstName()!=null && x.getLastName()!=null)
                .map(user -> new SimpleName(user.getFirstName(), user.getLastName())).toList();
    }


}
