package co.edu.icesi.functional;

import co.edu.icesi.model.IcesiAddress;
import co.edu.icesi.model.IcesiUser;

import javax.swing.text.html.Option;
import java.util.Optional;

public class OptionalExample {


    /**
     * Using optionals return the street of the given user if not present throw an
     * RuntimeException with the message "Couldn't get the street"
     *  value = 0.5
     * @param icesiUser an IcesiUser object
     * @return The street of the given icesiUser
     */
    public String obtainUserStreet(IcesiUser icesiUser) { // -0.5
        Optional<String> street = Optional.of(icesiUser.getAddress().getStreet()); // null pointer exception
        street.orElseThrow(()->{return new RuntimeException("Couldn't get the street");}
        ); // mal uso de orElseThrow
        return street.get(); // .get() ??
    }


    /**
     * Using Optionals return the description of the given user if not present return
     * a default description "default description"
     *  value = 0.5
     * @param icesiUser icesiUser an IcesiUser object
     * @return the description of the given icesiUser or "default description" if not present.
     */
    public String obtainUserDescription(IcesiUser icesiUser) { // -0.5 mal uso de optionals
        Optional<IcesiUser> user = Optional.ofNullable(icesiUser);
        IcesiAddress icesiAddress = new IcesiAddress();
        icesiAddress.setDescription("default description"); // SET???
        IcesiUser auxUser = new IcesiUser();
        auxUser.setAddress(icesiAddress);
        Optional<String> description = Optional.ofNullable(user.orElse(auxUser).getAddress().getDescription());
        return description.orElse("default description");
    }

}
