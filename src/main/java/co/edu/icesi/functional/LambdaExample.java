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
        return numero -> Integer.parseInt(numero);
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
        Supplier<String> cadenaRandom =  () -> randomStr(length);
        return cadenaRandom;
    }

    public String randomStr(int l){
        Random rand = new Random();
        String dictionary = "abcdefghijklmnopqrstuvwxyz";
        String cadena = "";
        for ( int i = 0; i < l; i++){
            cadena += dictionary.charAt(rand.nextInt(dictionary.length()));
        }
        return cadena;
    }

    /**
     *  Create a predicate using a lambda or method reference that filters the strings with repeated characters case-insensitive
     *  value = 0.75
     * @return a predicate that filters repeated characters case-insensitive of a string
     */
    public Predicate<String> containsRepeatedCharacters() {
        Predicate<String> checking = s -> repeatedCheck(s);
        return checking;
    }

    public boolean repeatedCheck(String cadena) {
        boolean state = true;
        for(int i = 0; i < cadena.length(); i++){
            for(int j = i+1; j < cadena.length(); j++){
                if(Character.toLowerCase(cadena.charAt(i)) == Character.toLowerCase(cadena.charAt(j))){
                    state = false;
                }
            }
        }
        return state;
    }


}
