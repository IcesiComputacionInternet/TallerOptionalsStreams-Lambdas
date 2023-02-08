package co.edu.icesi.functional;

import java.util.Locale;
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
        String str="";
        for (int i=0;i<length;i++){
            int letterRandom= (int) ((Math.random() * (max - min)) + min);
            str+=(char)letterRandom;
        }
        return str;
    }

    /**
     *  Create a predicate using a lambda or method reference that filters the strings with repeated characters case-insensitive
     *  value = 0.75
     * @return a predicate that filters repeated characters case-insensitive of a string
     */
    public Predicate<String> containsRepeatedCharacters() {

        return (str)-> repeatedCharacter(str) ;
    }
    public boolean repeatedCharacter(String str){
        str=str.toLowerCase();
        boolean rep=true;
        for(int i=0; i<str.length() && rep;i++){
            int count=0;
            for(int j=0; j<str.length();j++){
                if(str.charAt(i)==str.charAt(j)){
                    count++;
                }
                if(count>1){
                    rep=false;
                }

            }
        }

        return rep;
    }

}
