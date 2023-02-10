package co.edu.icesi.functional;

import co.edu.icesi.model.IcesiAddress;
import co.edu.icesi.model.IcesiUser;

import java.util.Optional;
import java.util.function.Supplier;

public class OptionalExample {


    /**
     * Using optionals return the street of the given user if not present throw an
     * RuntimeException with the message "Couldn't get the street"
     *  value = 0.5
     * @param icesiUser an IcesiUser object
     * @return The street of the given icesiUser
     */
    public String obtainUserStreet(IcesiUser icesiUser) {
        Optional<String> street = Optional.ofNullable(icesiUser.getAddress().getStreet()); // null pointer exception -0.4
        return street.orElseThrow(() -> new RuntimeException("Couldn't get the street"));
    }


    /**
     * Using Optionals return the description of the given user if not present return
     * a default description "default description"
     *  value = 0.5
     * @param icesiUser icesiUser an IcesiUser object
     * @return the description of the given icesiUser or "default description" if not present.
     */
    public String obtainUserDescription(IcesiUser icesiUser) {
        Optional<IcesiUser> user = Optional.ofNullable(icesiUser);
        Optional<IcesiAddress> address = Optional.ofNullable(user.get().getAddress()); // No such element exception -0.4
        return address.map(IcesiAddress::getDescription).orElse("default description");
    }


}
