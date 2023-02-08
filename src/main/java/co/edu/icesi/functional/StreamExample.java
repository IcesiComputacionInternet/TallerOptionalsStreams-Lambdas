package co.edu.icesi.functional;

import co.edu.icesi.model.IcesiAddress;
import co.edu.icesi.model.IcesiUser;
import co.edu.icesi.model.SimpleName;

import java.util.Collection;
import java.util.List;
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
        List<IcesiUser> notNullList=icesiUsers.stream().filter(iu->iu!=null).toList();
        List<String> listLastNames= notNullList.stream().map(IcesiUser::getLastName).toList();
        List<List<String>>  listAllLastNames=listLastNames.stream().map(str-> List.of(str.split(" "))).toList();
        List<String> flatMap=listAllLastNames.stream().flatMap(Collection::stream).distinct().sorted().toList();

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
    public List<IcesiUser> filterUsersByStreet(List<IcesiUser> icesiUsers, String street) {
        List<IcesiUser> notNullList=icesiUsers.stream().filter(iu->iu!=null && iu.getAddress()!=null).toList();
        List<IcesiUser> filterUsers=notNullList.stream().filter(iu->street.equals(iu.getAddress().getStreet())).toList();
        return filterUsers;
    }


    /**
     * given a list of IcesiUser's map the names to a SimpleName class.
     *  value = 0.5
     * @param icesiUsers icesiUsers a list of IcesiUser, can contain null values.
     * @return a list of SimpleName.
     */
    public List<SimpleName> mapToSimpleName(List<IcesiUser> icesiUsers) {
        List<IcesiUser> notNullList=icesiUsers.stream().filter(iu->iu!=null).toList();

        List<SimpleName> snMap=notNullList.stream().map(iu-> new SimpleName(iu.getFirstName(), iu.getLastName())).toList();

        return snMap;
    }


}
