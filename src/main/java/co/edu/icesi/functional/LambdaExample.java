package co.edu.icesi.functional;

import java.util.List;
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
    public final static String banco = "abcdefghijklmnopqrstuvwxyz"; //?????????????????? -0.25
    public Supplier<String> randomStringSupplier(int length) {
        return ()-> generateString(length);
    }

    private String generateString(int length){
        String cd = "";

        for(int i = 0; i < length; i++){
            cd += banco.charAt((int) (Math.random()*banco.length()));
        }

        return cd;
    }
    /**
     *  Create a predicate using a lambda or method reference that filters the strings with repeated characters case-insensitive
     *  value = 0.75
     * @return a predicate that filters repeated characters case-insensitive of a string
     */
    public Predicate<String> containsRepeatedCharacters() { // -0.1
        return x->repeatChar(x);
    }

    private boolean repeatChar(String string){ // y si usas streams?

        boolean repeat = true;
        boolean aux2 = true;
        char aux;
        StringBuilder str = new StringBuilder(string.toLowerCase());
        for(int i = 0; i < string.length() && aux2; i++){
            aux = str.charAt(i);
            str.replace(i,i+1," ");
            if(str.toString().contains(String.valueOf(aux))) {
                repeat = false;
            }
        }

        return repeat;
    }

}
