package co.edu.icesi.functional;

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
        return x-> Integer.parseInt(x);
    }

    /**
     * Create a supplier using a lambda or method reference that returns a random string of the
     * given length.
     * value = 0.75
     *
     * @param length the length of the random string
     * @return a random lowercase string of the given length
     */
    public Supplier<String> randomStringSupplier(int length) {
        return ()-> {
            String chain="";
            String characters = "abcdefghijklmnopqrstuvwyxz";
            for (int i = 0; i <length; i++) {
                int randomNumber = (int)(Math.random() * (characters.length()));
                String temp = String.valueOf(characters.charAt(randomNumber));
                chain+=temp;
            }
            return  chain;
        };
    }

    /**
     *  Create a predicate using a lambda or method reference that filters the strings with repeated characters case-insensitive
     *  value = 0.75
     * @return a predicate that filters repeated characters case-insensitive of a string
     */
    public Predicate<String> containsRepeatedCharacters() { // mal uso de un lambda, usar streams! -0.25
        return x-> {
            boolean withoutRepeat = false;
            for (int i = 0; i < x.length(); i++) {
                int count = 0;
                char character = Character.toLowerCase(x.charAt(i));
                for (int j = 0; j < x.length(); j++) {
                    if (character == Character.toLowerCase(x.charAt(j))) {
                        count++;
                    }
                }
                if (count == 1) {
                    withoutRepeat = true;
                } else {
                    withoutRepeat = false;
                }
            }
            return withoutRepeat;
        };
    }


}
