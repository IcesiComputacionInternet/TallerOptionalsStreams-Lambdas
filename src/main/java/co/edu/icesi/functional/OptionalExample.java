package co.edu.icesi.functional;

import co.edu.icesi.model.IcesiUser;

import java.util.Optional;

public class OptionalExample {


    /**
     * Using optionals return the street of the given user if not present throw an
     * RuntimeException with the message "Couldn't get the street"
     *  value = 0.5
     * @param icesiUser an IcesiUser object
     * @return The street of the given icesiUser
     */
    public String obtainUserStreet(IcesiUser icesiUser) {
        Optional<String> optionalString = Optional.ofNullable(icesiUser.getAddress().getStreet()); // Null pointer exception. -0.5
        return optionalString.orElseThrow(RuntimeException::new); // No agregaste el mensaje.
    }


    /**
     * Using Optionals return the description of the given user if not present return
     * a default description "default description"
     *  value = 0.5
     * @param icesiUser icesiUser an IcesiUser object
     * @return the description of the given icesiUser or "default description" if not present.
     */
    public String obtainUserDescription(IcesiUser icesiUser) {
        Optional<IcesiUser> optionalUser = Optional.ofNullable(icesiUser);
        return optionalUser.map((x) -> (x.getAddress().getDescription())).orElse("default description"); // this throws a null pointer exception -0.4
    }


}
