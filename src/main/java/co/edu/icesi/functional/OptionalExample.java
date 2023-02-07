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
    public String obtainUserStreet(IcesiUser icesiUser) {
        Optional<String> street = Optional.of(icesiUser.getAddress().getStreet());
        street.orElseThrow(()->{return new RuntimeException("Couldn't get the street");}
        );
        return street.get();
    }


    /**
     * Using Optionals return the description of the given user if not present return
     * a default description "default description"
     *  value = 0.5
     * @param icesiUser icesiUser an IcesiUser object
     * @return the description of the given icesiUser or "default description" if not present.
     */
    public String obtainUserDescription(IcesiUser icesiUser) {
        Optional<IcesiUser> user = Optional.of(icesiUser);
        Optional<String> description;
        if(user.isPresent()){
            description = Optional.of(user.get().getAddress().getDescription());
            description.orElse("default description");
        }else{
            description = Optional.of("default description");
        }

        return description.get();

    }

}
