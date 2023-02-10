package co.edu.icesi.functional;

import co.edu.icesi.model.IcesiUser;
import co.edu.icesi.model.SimpleName;

import java.lang.reflect.Array;
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
    public List<String> allDifferentLastNamesSorted(List<IcesiUser> icesiUsers) { // ojo con las lineas tan largas - 0.1
        return  icesiUsers.stream().filter(IcesiUser -> IcesiUser !=null && IcesiUser.getFirstName() !=null &&IcesiUser.getLastName() !=null) // usar optionals o filtrar a través de objects nonNull
                .map(IcesiUser::getLastName).flatMap(users -> Arrays.stream(users.split(" "))).distinct().sorted().toList();

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
    public List<IcesiUser> filterUsersByStreet(List<IcesiUser> icesiUsers, String street) { // - 1.0
        List<IcesiUser> usuarios = icesiUsers.stream().filter(IcesiUser -> IcesiUser !=null && IcesiUser.getAddress()!=null && IcesiUser.getAddress().getStreet() == street).toList(); // para que sirven los optionals? usar .equals no ==
        return usuarios;
    }

    /**
     * given a list of IcesiUser's map the names to a SimpleName class.
     *  value = 0.5
     * @param icesiUsers icesiUsers a list of IcesiUser, can contain null values.
     * @return a list of SimpleName.
     */
    public List<SimpleName> mapToSimpleName(List<IcesiUser> icesiUsers) { // - 0.5 por entregar después de las 4.
        List<IcesiUser> filtrados = icesiUsers.stream().filter(IcesiUser -> IcesiUser!=null && IcesiUser.getLastName()!=null &&IcesiUser.getFirstName()!=null).toList();
        List<SimpleName> usuario = filtrados.stream().map(icesiUser -> new SimpleName(icesiUser.getFirstName(), icesiUser.getLastName())).toList();
        return usuario;
    }


}
