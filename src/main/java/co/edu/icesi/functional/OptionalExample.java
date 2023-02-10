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
        Optional<String> userAddress = Optional.ofNullable(icesiUser.getAddress().getStreet()); // null pointer exception -0.4
        return userAddress.orElseThrow(()-> new RuntimeException("Couldn't get the street"));
        //return userAddress.orElseThrow(RuntimeException::new);
    }


    /**
     * Using Optionals return the description of the given user if not present return
     * a default description "default description"
     *  value = 0.5
     * @param icesiUser icesiUser an IcesiUser object
     * @return the description of the given icesiUser or "default description" if not present.
     */
    public String obtainUserDescription(IcesiUser icesiUser) { // mal uso de optionals -0.5

        Optional<IcesiUser> user = Optional.ofNullable(icesiUser);

        if(user.isPresent()){
            Optional<String> description = Optional.ofNullable(icesiUser.getAddress().getDescription());
            if(description.isPresent()) {
                return description.get();
            }else{
                return "default description";
            }
        }else{
            return "default description";
        }
    }


}
