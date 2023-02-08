package co.edu.icesi.functional;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class LambdaExample {

    /**
     *  Create a function using lambda notation that receives a String and parses it to an Int
     *  value = 0.5
     * @return an integer representation of the string
     */
    public Function<String, Integer> stringToIntFunction() {

        Function<String, Integer> parser = input -> (Integer.valueOf(input));
        return parser;
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

        return () -> generator(length);
    }

    public String generator(int length){
        Random random = new Random();
        String randomString = "";
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(122 - 97) + 97;
            randomString += (char) number;
        }
        return randomString;
    }

    /**
     *  Create a predicate using a lambda or method reference that filters the strings with repeated characters case-insensitive
     *  value = 0.75
     * @return a predicate that filters repeated characters case-insensitive of a string
     */
    public Predicate<String> containsRepeatedCharacters() {

        Predicate<String> word = i -> repeated(i);

        return word;
    }

    public boolean repeated(String word){

        long noDuplicated = word.toLowerCase().chars().distinct().count();
        int original = word.length();

        return noDuplicated == original;
    }


}
