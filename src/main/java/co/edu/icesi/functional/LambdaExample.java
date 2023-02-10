package co.edu.icesi.functional;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.Random;

public class LambdaExample {

    /**
     * Create a function using lambda notation that receives a String and parses it
     * to an Int
     * value = 0.5
     * 
     * @return an integer representation of the string
     */
    public Function<String, Integer> stringToIntFunction() {
        return value -> Integer.parseInt(value);
    }

    /**
     * Create a supplier using a lambda or method reference that returns a random
     * string of the
     * given length.
     * value = 0.75
     *
     * @param length the length of the random string
     * @return a random lowercase string of the given length
     */
    public Supplier<String> randomStringSupplier(int length) { // -0.1
        Supplier<String> randoms = () -> randomString(length); // no delcarar la interfaz!
        return randoms;
    }

    public String randomString(int n) {
        String letters = "abcdefghijklmnopqrstuvwxyz";
        Random rand = new Random();
        String chain = "";
        for (int i = 0; i < n; i++) {
            int val = rand.nextInt(letters.length());
            chain += letters.charAt(val);
        }
        return chain;
    }

    /**
     * Create a predicate using a lambda or method reference that filters the
     * strings with repeated characters case-insensitive
     * value = 0.75
     * 
     * @return a predicate that filters repeated characters case-insensitive of a
     *         string
     */
    public Predicate<String> containsRepeatedCharacters() { // -0.25
        Predicate<String> notRepeatedCharacters = s -> checkDuplicate(s); // no delcarar la interfaz!
        return notRepeatedCharacters;
    }

    public boolean checkDuplicate(String s) { // y si usas streams?
       CharSequence g = s;
       boolean duplicate = false;
        for (int i = 0; i < g.length(); i++) {
            for (int j = i + 1; j < g.length(); j++) {
                if (Character.toLowerCase(g.charAt(i)) == Character.toLowerCase(g.charAt(j))) {
                    duplicate = true;
                }
            }
        }
        return !duplicate;
    }

}
