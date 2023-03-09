package com.nikki.colecciones.ejemplos.set;

import java.util.HashSet;
import java.util.Set;

public class EjemploHashSetBuscarDuplicados {
    public static void main(String[] args) {
        String[] peces = {"Corvina", "Lenguado", "Atun", "Lenguado", "Pejerrey", "Robalo"};
        Set<String> unicos = new HashSet<>();
        for (String pez : peces) {
            if (!unicos.add(pez)) {
                System.out.println("Elemento duplicado:  " + pez);
            }
        }
        System.out.println("" + unicos.size() + " elementos no duplicados " + unicos);
    }
}
