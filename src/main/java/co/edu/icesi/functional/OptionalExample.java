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
        Optional<IcesiUser> optionalUser = Optional.ofNullable(icesiUser);
        Optional<String> optionalStreet;

        if(optionalUser.isPresent()){
            optionalStreet = Optional.ofNullable(icesiUser.getAddress().getStreet());
            if(optionalStreet.isPresent()){

                return optionalUser.get().getAddress().getStreet();

            } else {
                throw new RuntimeException("Couldn't get the street");
            }
        } else{
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

        Optional<IcesiUser> optional = Optional.ofNullable(icesiUser);
        Optional<String> optionalDescription;

        if(optional.isPresent()){

            optionalDescription = Optional.ofNullable(icesiUser.getAddress().getDescription());

            if(optionalDescription.isPresent()){
                return optionalDescription.get();
            } else {
                return "default description";
            }
        } else {
            return  "default description";
        }
    }


}
