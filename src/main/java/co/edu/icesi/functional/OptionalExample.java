package co.edu.icesi.functional;

import co.edu.icesi.model.IcesiAddress;
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

    Optional<IcesiAddress> optional = Optional.ofNullable(icesiUser.getAddress());
    if(optional.isPresent()){
        return icesiUser.getAddress().getStreet();
    }else{
        throw new RuntimeException("Couldn't get the street");
    }

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
        String description;
        Optional<String> optionalDescription = Optional.ofNullable(null);
        if(optionalUser.isPresent()){
            optionalDescription = Optional.ofNullable(icesiUser.getAddress().getDescription());
        }
        if(optionalDescription.isPresent()) {
            description = icesiUser.getAddress().getDescription();
        }else{
            description = "default description";
        }
        return description;
    }


}
