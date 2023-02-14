package co.edu.icesi.functional;

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
        return (str) -> Integer.parseInt(str);
    }

    /**
     * Create a supplier using a lambda or method reference that returns a random string of the
     * given length.
     * value = 0.75
     *
     * @param length the length of the random string
     * @return a random lowercase string of the given length
     */
    public Supplier<String> randomStringSupplier(int length) { // -0.65
        return () -> generatedString(length);
    }
    public String generatedString(int length) {
        String letter = "abcdefghijklmnopqrstvwxyz";
        StringBuilder txt = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
           int num = random.nextInt(letter.length()); // corregido
           txt.append(letter.charAt(num));
        }
        return txt.toString();
    }
    /**
     *  Create a predicate using a lambda or method reference that filters the strings with repeated characters case-insensitive
     *  value = 0.75
     * @return a predicate that filters repeated characters case-insensitive of a string
     */
    public Predicate<String> containsRepeatedCharacters() { // corregido
        return (txt) -> txt.toUpperCase().chars().distinct().count() == txt.length();
    }
}
