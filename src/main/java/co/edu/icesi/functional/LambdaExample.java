package co.edu.icesi.functional;

import java.util.Objects;
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
        Function<String, Integer> parseString = (String s) -> Integer.parseInt(s); // porque una funcion intermedia y no retornar el valor de una vez?
        return parseString;
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
        return () -> fillRandomString(length); // -0.25
    }

    private String fillRandomString(int length) { // esta funcion no cumple con las caracteristicas
        String randomString = "";
        for (int i = 0; i < length; i++) {
            randomString += (char) (Math.random() * 26 + 'a');
        }
        return randomString;
    }

    /**
     *  Create a predicate using a lambda or method reference that filters the strings with repeated characters case-insensitive
     *  value = 0.75
     * @return a predicate that filters repeated characters case-insensitive of a string
     */
    public Predicate<String> containsRepeatedCharacters() {
        return (x) -> x.toLowerCase().chars().distinct().count() == x.length(); // cuidado con los nombres de las variables
    }


}
