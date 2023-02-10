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
        Function<String, Integer> function = (stringX) -> Integer.parseInt(stringX); // porque no retornar de una vez? - 0.1
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

        return () -> { // ojo con esta forma de declarar lambdas, no es una buena practica y lo mencione en clase!
            // -0.25

            String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // porque mayusculas para luego hacer un .lowercase?
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

        Predicate<String> predicate = s -> verifyRepeatition(s); // no delcarar los predicates o functions de esta forma! -0.1
        return predicate;
    }

    public boolean verifyRepeatition(String word){
        String wordFiltered = word.toLowerCase();
        long wordNonDuplicated = wordFiltered.chars().distinct().count();
        int originalLength = word.length();

        return wordNonDuplicated == originalLength;

    }


}
