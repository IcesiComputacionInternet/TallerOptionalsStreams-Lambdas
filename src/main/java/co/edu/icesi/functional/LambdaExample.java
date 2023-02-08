package co.edu.icesi.functional;

import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.random.RandomGenerator;

public class LambdaExample {

    /**
     *  Create a function using lambda notation that receives a String and parses it to an Int
     *  value = 0.5
     * @return an integer representation of the string
     */
    public Function<String, Integer> stringToIntFunction() {
        return numberString->Integer.valueOf(numberString);
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
            String finalRandomWord="";
            String alphabet="abcdefghijklmnopqrstuvwxyz";
            Random randomFuction=new Random();

            for (int i = 0; i <length ; i++) {
                int index=randomFuction.nextInt(alphabet.length());
                char ramdomCharValue= alphabet.charAt(index);
                finalRandomWord+=ramdomCharValue;
            }
            return finalRandomWord;
        };
    }

    /**
     *  Create a predicate using a lambda or method reference that filters the strings with repeated characters case-insensitive
     *  value = 0.75
     * @return a predicate that filters repeated characters case-insensitive of a string
     */
    public Predicate<String> containsRepeatedCharacters() {
        return (sentence) -> sentence.toLowerCase().chars().distinct().count() == sentence.length();
    }
}
