package co.edu.icesi.functional;

import java.util.Locale;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaExample {


    //
    /**
     *  Create a function using lambda notation that receives a String and parses it to an Int
     *  value = 0.5
     * @return an integer representation of the string
     */
    public Function<String, Integer> stringToIntFunction() {

        return (num)->Integer.parseInt(num);
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

        return () -> getRandomString(length);
    }

    public String getRandomString(int length){
        int max=122;
        int min=97;
        Random random = new Random();
        String str = random.ints(min,max+1)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint,StringBuilder::append)
                .toString();
        // usar String builder! (ok)
        return str;
    }


    /**
     *  Create a predicate using a lambda or method reference that filters the strings with repeated characters case-insensitive
     *  value = 0.75
     * @return a predicate that filters repeated characters case-insensitive of a string
     */
    public Predicate<String> containsRepeatedCharacters() { // -0.1
    // y si usas streams? (ok)
        return (str)-> str.toLowerCase().chars().distinct().count()==str.length() ;
    }


}
