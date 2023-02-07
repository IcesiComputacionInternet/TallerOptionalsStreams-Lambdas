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
        Optional<IcesiUser> icesiUserX = Optional.of(icesiUser);
        if(icesiUserX.isEmpty()){
            return null;
        }else{
            Optional<String> optionalStreet = Optional.ofNullable(icesiUser.getAddress().getStreet());
            if(optionalStreet.isPresent()){
                return icesiUser.getAddress().getStreet();
            }else{
                throw new RuntimeException("Couldn't get the street");
            }
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
        Optional<IcesiUser> icesiUserOptional = Optional.ofNullable(icesiUser);
        if(icesiUserOptional.isEmpty()){
            return "default description";
        }else{
            Optional<String> optionalDescription = Optional.ofNullable(icesiUser.getAddress().getDescription());
            if(optionalDescription.isPresent()){
                return icesiUser.getAddress().getDescription();
            }else{
                return "default description";
            }
        }
    }


}
