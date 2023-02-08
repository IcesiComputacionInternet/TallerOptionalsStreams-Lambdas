package co.edu.icesi.functional;

import java.util.HashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.Random;

public class LambdaExample {

    /**
     *  Create a function using lambda notation that receives a String and parses it to an Int
     *  value = 0.5
     * @return an integer representation of the string
     */
    public Function<String, Integer> stringToIntFunction() {
        return (numero) -> Integer.parseInt(numero);
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
        return () -> generateString(length);
    }

    private String generateString(int length){
        String stringMessage = "";
        String letters = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();

        for(int i = 0; i < length; i++){
            stringMessage += String.valueOf(letters.charAt(random.nextInt(letters.length())));
        }

        return stringMessage;
    }

    /**
     *  Create a predicate using a lambda or method reference that filters the strings with repeated characters case-insensitive
     *  value = 0.75
     * @return a predicate that filters repeated characters case-insensitive of a string
     */
    public Predicate<String> containsRepeatedCharacters() {
        return (characters) -> stringContainsRepeatedCharacters(characters);
    }

    private boolean stringContainsRepeatedCharacters(String characters){
        boolean verification = true;
        HashMap<String, Integer> letters = new HashMap<String, Integer>();

        for (int i = 0; i < characters.length() && verification; i++){
            String letterInCharacters = String.valueOf(characters.charAt(i)).toLowerCase();

            if(!letters.containsKey(letterInCharacters)){
                letters.put(letterInCharacters, Integer.valueOf(0));
            }else{
                verification = false;
            }
        }

        return verification;
    }


}
