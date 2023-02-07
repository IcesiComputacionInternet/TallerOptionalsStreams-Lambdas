package co.edu.icesi.functional;

import java.util.Optional;

import co.edu.icesi.model.IcesiAddress;
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
        Optional<String> optStreet = Optional.ofNullable(icesiUser).map(IcesiUser::getAddress).map(IcesiAddress::getStreet);
        if (optStreet.isEmpty()) {
            optStreet.orElseThrow( () -> "Couldn't get the street");
        } else {
            optStreet.orElse(icesiUser.getAddress().getStreet());

        }
        //String result = optStreet.orElse("Couldn't get the street");
    }


    /**
     * Using Optionals return the description of the given user if not present return
     * a default description "default description"
     *  value = 0.5
     * @param icesiUser icesiUser an IcesiUser object
     * @return the description of the given icesiUser or "default description" if not present.
     */
    public String obtainUserDescription(IcesiUser icesiUser) {
        return null;
    }


}
