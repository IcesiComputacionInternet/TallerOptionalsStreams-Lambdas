package co.edu.icesi.functional;

import java.util.List;
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
        return x -> Integer.parseInt(x);
    }

    /**
     * Create a supplier using a lambda or method reference that returns a random string of the
     * given length.
     * value = 0.75
     *
     * @param length the length of the random string
     * @return a random lowercase string of the given length
     */
    public final static String banco = "abcdefghijklmnopqrstuvwxyz";
    public Supplier<String> randomStringSupplier(int length) {
        return ()-> generateString(length);
    }

    private String generateString(int length){
        String cd = "";

        for(int i = 0; i < length; i++){
            cd += banco.charAt((int) (Math.random()*banco.length()));
        }

        return cd;
    }
    /**
     *  Create a predicate using a lambda or method reference that filters the strings with repeated characters case-insensitive
     *  value = 0.75
     * @return a predicate that filters repeated characters case-insensitive of a string
     */
    public Predicate<String> containsRepeatedCharacters() {

        Predicate<String> characters = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return false;
            }
        };

        return null;
    }


}
