package com.nikki.api.stream.ejeplo;

import java.util.Arrays;
import java.util.stream.Stream;

public class EjemploStreamAplanarArregloEliminarRepetidos {
    public static void main(String[] args) {
        /*El siguiente ejercicio es aplanar un arreglo bidimensional en un nivel y eliminar repetidos usando el api stream.
        Aplanar un arreglo significa quitar los elementos del arreglo anidado y dejarlos en el arreglo de primer nivel.
        * */
        String[][] lenguajes1 = {{"java", "groovy"}, {"php"}, {"c#", "python", "groovy"}, {"java", "javascript", "kotlin"}, {"javascript"}, {}};
        Arrays.stream(Arrays
                        .stream(lenguajes1).toArray())
                .forEach(System.out::println);
        System.out.println(Arrays.deepToString(lenguajes1));
    }
}
