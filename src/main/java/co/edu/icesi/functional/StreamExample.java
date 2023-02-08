package co.edu.icesi.functional;

import co.edu.icesi.model.IcesiAddress;
import co.edu.icesi.model.IcesiUser;
import co.edu.icesi.model.SimpleName;

import java.util.*;


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
        return icesiUsers.stream()
                .filter(this::stringCheck)
                .map(IcesiUser::getLastName)
                .flatMap(x ->Arrays.stream(x.split(" ")))
                .sorted().distinct().toList();


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
        return  icesiUsers.stream()
                .filter(x->streetMatch(x, street))
                .toList();
    }

    private boolean streetMatch(IcesiUser icesiUser, String street){
        return Optional.ofNullable(icesiUser)
                .map(IcesiUser::getAddress)
                .map(IcesiAddress::getStreet)
                .filter(street::equals).isPresent();
    }

    /**
     * given a list of IcesiUser's map the names to a SimpleName class.
     *  value = 0.5
     * @param icesiUsers icesiUsers a list of IcesiUser, can contain null values.
     * @return a list of SimpleName.
     */
    public List<SimpleName> mapToSimpleName(List<IcesiUser> icesiUsers) {
            //<String> names = icesiUsers.stream().filter(x->stringCheck(x)).map(IcesiUser::getFirstName).toList();
            //List<String> lastnames = icesiUsers.stream().filter(x->stringCheck(x)).map(IcesiUser::getLastName).toList();
            return icesiUsers.stream().filter(this::stringCheck).map(x->new SimpleName(x.getFirstName(), x.getLastName())).toList();

    }
/*
    private List<SimpleName> createSimpleNames(List<String> names,List<String> lastnames){
        List<SimpleName> simpleNames = new ArrayList<>();

        for (int i = 0; i < names.size(); i++) {
            simpleNames.add(new SimpleName(names.get(i),lastnames.get(i)));
        }
        return simpleNames;
    }
*/
    private boolean stringCheck(IcesiUser icesiUser){
        return Optional.ofNullable(icesiUser)
                .isPresent();
    }

}
