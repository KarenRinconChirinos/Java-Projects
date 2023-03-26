package com.nikki.api.stream.ejeplo;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

public class EjemploStreamNumeroMayor {
    public static void main(String[] args) {
        /*Obtener el numero mayor en un arreglo con
        programación funcional lambda y api stream
        * */

        Function<Integer[], Integer> numeros =  n -> Arrays.stream(n).reduce(0,(a,b) -> {
            if(a>b){
                return a;
            }
            return b;
        });
        int mayor = numeros.apply(new Integer[]{1,2,6,4,3,5,6,7,8,9,1,2,4});
        System.out.println(mayor);


    }

}
