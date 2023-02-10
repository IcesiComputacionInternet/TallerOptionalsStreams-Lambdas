package co.edu.icesi.functional;

import java.util.ArrayList;
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
        return x -> Integer.valueOf(x);
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
        return () -> randomString(length);
    }

    public String randomString(int length) {
        String result = "";
        for (int i = 0; i < length; i++) {
            Random r = new Random();
            char c = (char) (r.nextInt(26) + 'a');
            System.out.println(c);
            result = result + c;
        }
        return result;
    }

    /**
     *  Create a predicate using a lambda or method reference that filters the strings with repeated characters case-insensitive
     *  value = 0.75
     * @return a predicate that filters repeated characters case-insensitive of a string
     */
    public Predicate<String> containsRepeatedCharacters() {
        return (x) -> repeatedVerifier(x);
    }

    public boolean repeatedVerifier(String word) { // y si usas streams para esto? -0.1
        ArrayList<Character> filtered = new ArrayList<>();
        for(int i=0; i<word.length(); i++) {
            if(!filtered.contains(word.charAt(i)) && !filtered.contains(Character.toUpperCase(word.charAt(i))) ) {
                filtered.add(word.charAt(i));
            }
        }
        if(word.length() == filtered.size()) {
            return true;
        }
        else {
            return false;
        }
    }

}
