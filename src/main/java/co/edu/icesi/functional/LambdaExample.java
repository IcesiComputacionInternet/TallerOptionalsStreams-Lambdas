package co.edu.icesi.functional;

import java.util.List;
import java.util.Random;
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
        Function<String, Integer> function = (stringX) -> Integer.parseInt(stringX);
        return function;
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

        return () -> {

            String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            Random random = new Random();
            StringBuilder sb = new StringBuilder(length);

            for(int i = 0; i < length; i++) {

                int index = random.nextInt(alphabet.length());
                char randomChar = alphabet.charAt(index);

                // append the character to string builder
                sb.append(randomChar);
            }

            String randomString = sb.toString().toLowerCase();
            return randomString;
        };

    }

    /**
     *  Create a predicate using a lambda or method reference that filters the strings with repeated characters case-insensitive
     *  value = 0.75
     * @return a predicate that filters repeated characters case-insensitive of a string
     */
    public Predicate<String> containsRepeatedCharacters() {

        /*List<String> result = null;

        Predicate<String> predicate = s -> {
            int cont = 0;
            for (int i = 0; i < s.length(); i++) {
                if(chain.charAt(i) == character) {
                    cont++;
                }
            }
            return result.equals(null);
        };
        return predicate;*/
        return null;
    }


}
