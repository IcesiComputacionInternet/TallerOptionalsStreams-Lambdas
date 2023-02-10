package co.edu.icesi.functional;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaExample {

    /**
     *  Create a function using lambda notation that receives a String and parses it to an Int
     *  value = 0.5
     * @return an integer representation of the string
     */
    public Function<String, Integer> stringToIntFunction() {
        return (x->Integer.parseInt(x));
    }

    /**
     * Create a supplier using a lambda or method reference that returns a random string of the
     * given length.
     * value = 0.75
     *
     * @param length the length of the random string
     * @return a random lowercase string of the given length
     */
    public Supplier<String> randomStringSupplier(int length) { // mal uso de lambda -0.1
        return (()->{String AlphaNumericStr = "abcdefghijklmnopqrstuvxyz";
            StringBuilder s = new StringBuilder(length);
            for ( int i=0; i<length; i++) {
                int ch = (int)(AlphaNumericStr.length() * Math.random());
                s.append(AlphaNumericStr.charAt(ch));
            }
            return s.toString();});
    }

    /**
     *  Create a predicate using a lambda or method reference that filters the strings with repeated characters case-insensitive
     *  value = 0.75
     * @return a predicate that filters repeated characters case-insensitive of a string
     */
    public Predicate<String> containsRepeatedCharacters() { // mal uso de lambda, se puede hacer la funcion con streams -0.25
        return(x-> {
            x = x.toLowerCase();
            ArrayList<Character> uniques = new ArrayList<Character>();
            for (int i = 0; i < x.length(); i++) {
                if(uniques.contains(x.charAt(i))){
                    return false;
                }else{
                    uniques.add(x.charAt(i));
                }
            }
            return true;
        });
    }

    }
