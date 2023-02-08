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
    public Supplier<String> randomStringSupplier(int length) {
       return () -> randomStringSupplierMethod(length);
    }

    public String randomStringSupplierMethod(int len) {
        String word = "";
        int numASCII=65;
        for(int k=0;k<len;k++) {
            word+=Character.toString((char) numASCII);
            numASCII++;
        }
        return word.toLowerCase();
    }

    /**
     *  Create a predicate using a lambda or method reference that filters the strings with repeated characters case-insensitive
     *  value = 0.75
     * @return a predicate that filters repeated characters case-insensitive of a string
     */
    public Predicate<String> containsRepeatedCharacters() {
        return (word) -> filterStringPredicateMethod(word);
    }

    public boolean filterStringPredicateMethod(String w){
        boolean repeated=true;
        int cont;
        String letterk;
        String letterj;
        for (int k=0;k<w.length();k++){
            cont=0;
            letterk=String.valueOf(w.charAt(k));
            for (int j=0;j<w.length();j++){
                letterj=String.valueOf(w.charAt(j));
                if (letterk.equalsIgnoreCase(letterj)){
                    cont+=1;
                }
            }
            if (cont>=2){
                repeated=false;
            }
        }
        return repeated;
    }

}
