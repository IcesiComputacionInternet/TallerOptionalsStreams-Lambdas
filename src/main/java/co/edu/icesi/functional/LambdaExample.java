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
        return (str) -> Integer.parseInt(str);
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
        return () -> generatedString(length);
    }
    public String generatedString(int length) {
        String letter = "abcdefghijklmnopqrstvwxyz";
        String txt = "";
        for (int i = 0; i < length; i++) {
           int num = (int) (Math.random());
           txt += letter.charAt(num);
        }
        return txt;
    }
    /**
     *  Create a predicate using a lambda or method reference that filters the strings with repeated characters case-insensitive
     *  value = 0.75
     * @return a predicate that filters repeated characters case-insensitive of a string
     */
    public Predicate<String> containsRepeatedCharacters() {
        return (txt) -> filterChar(txt);
    }

    public boolean filterChar(String txt) {
        boolean repeated = true;
        int letter;
        char save[] = txt.toCharArray();
        for (int i = 0; i < txt.length(); i++) {
            letter = 0;
            for (int j = 0; j < txt.length(); j++) {
                String ltr1 = String.valueOf(save[i]);
                String ltr2 = String.valueOf(save[j]);
                if(ltr1.equalsIgnoreCase(ltr2)) {
                    letter++;
                }
                if(letter > 1){
                    repeated = false;
                } else {
                    repeated = true;
                }
            }
        }
        return repeated;
    }

}
