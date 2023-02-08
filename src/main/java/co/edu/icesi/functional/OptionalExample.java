package co.edu.icesi.functional;

import java.util.Optional;

import co.edu.icesi.model.IcesiUser;

public class OptionalExample {


    /**
     * Using optionals return the street of the given user if not present throw an
     * RuntimeException with the message "Couldn't get the street"
     *  value = 0.5
     * @param icesiUser an IcesiUser object
     * @return The street of the given icesiUser
     */
    public String obtainUserStreet(IcesiUser icesiUser) {
        return Optional.of(icesiUser.getAddress().getStreet()).orElse("Couldn't get the street");
    }


    /**
     * Using Optionals return the description of the given user if not present return
     * a default description "default description"
     *  value = 0.5
     * @param icesiUser icesiUser an IcesiUser object
     * @return the description of the given icesiUser or "default description" if not present.
     */
    public String obtainUserDescription(IcesiUser icesiUser) {
        return Optional.ofNullable(icesiUser).map(x -> x.getAddress().getDescription()).orElse("default description");
    }


}
