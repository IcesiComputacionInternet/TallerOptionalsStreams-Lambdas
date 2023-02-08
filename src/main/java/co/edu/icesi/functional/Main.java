package co.edu.icesi.functional;

import co.edu.icesi.model.IcesiAddress;
import co.edu.icesi.model.IcesiUser;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<IcesiUser> icesiUsers = new ArrayList<>(Arrays.asList(
                new IcesiUser("John", "Doe"),
                new IcesiUser("Jane", "Van Der Doe"),
                new IcesiUser("Jim", "Smith")
        ));
        /**List<Optional<IcesiUser>> optionals = icesiUsers.stream().map(x->Optional.ofNullable(x)).toList();
        List<Optional<IcesiUser>> filteredOptionals = optionals.stream().filter()**/
        icesiUsers = icesiUsers.stream().filter(x->x!=null).toList();
        List<String> lastnames = icesiUsers.stream().map(IcesiUser::getLastName).toList();
        List<String[]> horror = lastnames.stream().map(x->x.split(" ")).toList();
        List<String> result = horror.stream().flatMap(Arrays::stream).toList();

        List<String> filtered = result.stream().distinct().toList();
        filtered = filtered.stream().sorted().toList();
        System.out.println(filtered.toString());
    }
}
