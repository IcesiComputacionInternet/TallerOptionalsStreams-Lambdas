package co.edu.icesi.functional;

import co.edu.icesi.model.IcesiUser;
import co.edu.icesi.model.SimpleName;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StreamExample {

    /**
     * given a list of IcesiUser's get all the different lastnames if is a composed lastname each one of them
     * will count as a individual lastname. example "Prada Calderon" counts as "Prada" and "Calderon"
     * value = 1.0
     *
     * @param icesiUsers a list of IcesiUser, can contain null values.
     * @return a sorted list of different lastnames.
     */
    public List<String> allDifferentLastNamesSorted(List<IcesiUser> icesiUsers) { // -0.8 no uso de streams para resolver el ejercicio en su totalidad.
        //Without nulls
        List<IcesiUser> filterNoNull = icesiUsers.stream().filter(icesiUser -> icesiUser!=null).toList();
        //Lastnames to a list
        List<String[]> lastNames = filterNoNull.stream().map(icesiUser -> icesiUser.getLastName().split(" ")).toList();
        List<String> transform = new ArrayList<String>();
        // Only one list of string
            for (int i = 0; i < lastNames.size() ; i++) {
                for (int j = 0; j < lastNames.get(i).length; j++) {
                    transform.add(lastNames.get(i)[j]);
                }
            }
       // Show the distinct and order
        List<String > result = transform.stream().distinct().toList().stream().sorted().toList();
        return  result;
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
    public List<IcesiUser> filterUsersByStreet(List<IcesiUser> icesiUsers, String street) { // -0.5
        Optional<String> optionalStreet = Optional.of(street);
        List<IcesiUser> filtered = new ArrayList<>();
        if(optionalStreet.isPresent()) { //?????????
            List<IcesiUser> filterNoNull = icesiUsers.stream().filter(icesiUser -> icesiUser.getAddress()!=null && icesiUser.getAddress().getStreet()!=null).toList();
            filtered = filterNoNull.stream().filter(icesiUser -> icesiUser.getAddress().getStreet().matches(street)).toList(); // MATCHES?
        }
        return filtered;
    }

    /**
     * given a list of IcesiUser's map the names to a SimpleName class.
     *  value = 0.5
     * @param icesiUsers icesiUsers a list of IcesiUser, can contain null values.
     * @return a list of SimpleName.
     */
    public List<SimpleName> mapToSimpleName(List<IcesiUser> icesiUsers) { // despues de las 4pm -0.5
        List<IcesiUser> filterNoNull = icesiUsers.stream().filter(icesiUser -> icesiUser!=null).toList();
        List<SimpleName> simpleName = filterNoNull.stream().map(icesiUser -> new SimpleName(icesiUser.getFirstName(), icesiUser.getLastName())).toList();
        return simpleName;
    }


}
