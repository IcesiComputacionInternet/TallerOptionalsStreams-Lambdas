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
        return (numero)-> Integer.parseInt(numero);
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

        return () -> cadenas(length); // -0.25
    }
    public String cadenas(int length){ // este metodo no funciona
        String out ="";
        String texto = "abcdefghijklmnopqrstuvxyz";

        for (int i=0; i<length; i++) {
            int ch = (int)(Math.random());
            out = out+texto.charAt(ch);
        }

        return out;
    }
    /**
     *  Create a predicate using a lambda or method reference that filters the strings with repeated characters case-insensitive
     *  value = 0.75
     * @return a predicate that filters repeated characters case-insensitive of a string
     */
    public Predicate<String> containsRepeatedCharacters() { // -0.25 porque usas tantos for para verificar duplicados
        return (valor) -> verificarRepetidos(valor);
    }

    public Boolean  verificarRepetidos(String valor){
       Boolean out = true;
       int cantidad = 0;
        for(int i = 0; i<valor.length();i++){
            for(int j = 0 ; j <valor.length();j++){
                String a = String.valueOf(valor.charAt(i));
                String b = String.valueOf(valor.charAt(j));
                if( a.equalsIgnoreCase(b)){
                    cantidad++;
                }
                if(cantidad > 1){
                    out = false;
                }
            }
            cantidad = 0;
        }
       return  out;
    }
}
