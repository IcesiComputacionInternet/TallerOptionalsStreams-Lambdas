package co.edu.icesi.functional;

import org.jetbrains.annotations.NotNull;

import java.util.Locale;
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

    public String randomString(int length){
        String s = "";
        Random r = new Random();
        for(int i = 0; i<length; i++){
            s += (char) (r.nextInt(26)+'a');
        }
        return s;
    }

    /**
     *  Create a predicate using a lambda or method reference that filters the strings with repeated characters case-insensitive
     *  value = 0.75
     * @return a predicate that filters repeated characters case-insensitive of a string
     */
    public Predicate<String> containsRepeatedCharacters() {
        Predicate<String> repeatedLetters = new Predicate<String>() {
            @Override
            public boolean test(@NotNull String s) {
                s = s.toLowerCase(Locale.ROOT);
                for (int i = 0; i< s.length()-1; i++){
                    if(s.charAt(i) == s.charAt(i+1)){
                        return false;
                    }
                }
                return true;
            }
        };
        return repeatedLetters;
    }


}
