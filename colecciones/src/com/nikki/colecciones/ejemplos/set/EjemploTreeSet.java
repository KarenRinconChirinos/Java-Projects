package com.nikki.colecciones.ejemplos.set;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class EjemploTreeSet {
    public static void main(String[] args) {
        Set<String> treeset = new TreeSet<>((a,b)->b.compareTo(a));
        //Set<String> treeset = new TreeSet<>(Comparator.reverseOrder());
        //tiene  mayor costo de rendimientos porque son ordenadosn
        treeset.add("uno");
        treeset.add("dos");
        treeset.add("tres");
        treeset.add("tres");
        treeset.add("cuatro");
        treeset.add("cinco");
        //ordenar confomr tabla unicode o alfabeitoc
        System.out.println("treeset = " + treeset);

        System.out.println(" =========================== numeros =============================== ");
        Set<Integer> numeros =  new TreeSet<>(new Comparator<Integer>() { // se puede usar expresiones lambda
            @Override
            public int compare(Integer a, Integer b) {
                return b.compareTo(a);
            }
        });
        numeros.add(1);
        numeros.add(2);
        numeros.add(5);
        numeros.add(9);
        numeros.add(3);
        numeros.add(7);// aplica el orden de los elementos de forma automatica
        //no podemos clocar cualquier objeto, se debe poder cumplir con el contrato de ser comparables
        System.out.println("numeros = " + numeros);

        
    }
}
