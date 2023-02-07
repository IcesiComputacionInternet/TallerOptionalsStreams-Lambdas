package co.edu.icesi.functional;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.regex.Pattern;

public class LambdaExample {

    /**
     *  Create a function using lambda notation that receives a String and parses it to an Int
     *  value = 0.5
     * @return an integer representation of the string
     */
    public Function<String, Integer> stringToIntFunction() {
        return x -> Integer.parseInt(x);
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
        String randomString = generateRandomString(length).toLowerCase();
        return () -> randomString;
    }

    private String generateRandomString(int length){
        char[] array = new char[length];
        Random r = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = (char)(r.nextInt(26) + 'a');
        }
        return new String(array);
    }

    /**
     *  Create a predicate using a lambda or method reference that filters the strings with repeated characters case-insensitive
     *  value = 0.75
     * @return a predicate that filters repeated characters case-insensitive of a string
     */
    public Predicate<String> containsRepeatedCharacters() {
        Pattern noRepeatedCharacters = Pattern.compile("[ -~]?");
        return x -> checkRepeatedCharacters(x.toLowerCase());
    }

    private boolean checkRepeatedCharacters(String str){
        ArrayList<Character> characters = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            Character tempChar = str.charAt(i);
            if(characters.contains(tempChar)){
                return false;
            }else {
                characters.add(tempChar);
            }
        }
        return true;
    }
}
