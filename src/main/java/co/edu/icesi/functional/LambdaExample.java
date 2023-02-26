package co.edu.icesi.functional;

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
        return (string) -> Integer.parseInt(string);
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
       return () -> randomStringSupplierMethod(length);
    }
    //Implementación con la función random
    public String randomStringSupplierMethod(int len) {
        String Alphabet = "abcdefghijklmnopqrstuvxyz";
        StringBuilder word = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            int index = (int)(Alphabet.length() * Math.random());
            word.append(Alphabet.charAt(index));
        }
        return word.toString();
    }

    /**
     *  Create a predicate using a lambda or method reference that filters the strings with repeated characters case-insensitive
     *  value = 0.75
     * @return a predicate that filters repeated characters case-insensitive of a string
     */
    public Predicate<String> containsRepeatedCharacters() { // -0.25
        return (word) -> filterStringPredicateMethod(word);
    }

    public boolean filterStringPredicateMethod(String w){ // y si usas streams? ademas, muchos for para la funcion
        //uso de funcion chars() de stream
        return w.toLowerCase().chars().distinct().count() == w.toLowerCase().length();
    }

}
