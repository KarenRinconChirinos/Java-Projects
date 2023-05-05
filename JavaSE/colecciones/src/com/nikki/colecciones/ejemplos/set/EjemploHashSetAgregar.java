package com.nikki.colecciones.ejemplos.set;

import java.util.*;

public class EjemploHashSetAgregar {
    public static void main(String[] args) {
        System.out.println("  =========================== HashSet ========================= ");
        HashSet<String> hashSet = new HashSet<>(); //implementacion conreta
        //es mejor definirlo de su forma mas generica con la interfaz
        Set<String> hs = new HashSet<>(); //implementacion conreta
        hs.add("uno");//parecido a list porque son del mismo padre // retornea un boolean
        hs.add("dos");
        hs.add("tres");
        hs.add("cuatro");
        hs.add("cinco");
        System.out.println("hs = " + hs); // no es ordenado
        //Para poder volverlo ordenado, podria convertirse en un list
        //List<String> hashsetalist = new ArrayList<>(hashSet);
        boolean b = hs.add("tres");
        System.out.println("permite elementos duplicados = " + b);
        System.out.println("hs = " + hs); // no se muestra el 3 porque esta repetido

        /////////////////////////////////LIST

        System.out.println("  =========================== lList ========================= ");
        List<String> list = new ArrayList<>(); //implementacion conreta
        list.add("uno");
        list.add("dos");
        list.add("tres");
        list.add("cuatro");
        list.add("cinco");
        System.out.println("list = " + list); // es ordenado
        Collections.sort(list);
        boolean c = list.add("tres");
        System.out.println("permite elementos duplicados = " + c);
        System.out.println("hs = " + list); // no se muestra el 3 porque esta repetido

    }
}
