package com.nikki.api.stream.ejemplo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class EjemploStream {
    public static void main(String[] args) {
         Stream<String> nombres = Stream.of("pato", "paco", "pepa", "pepe"); //el stream es una interface
         nombres.forEach(System.out::println);//(e -> System.out.println(e));

        String[] arr = {"pato", "paco", "pepa", "pepe"};
        nombres = Arrays.stream(arr);
        nombres.forEach(System.out::println);

        Stream<String> nombres2 = Stream.<String>builder().add("Pato")
                .add("paco")
                .add("pepa")
                .add("pepe")
                .build();
        nombres2.forEach(System.out::println);

        List<String> lista = new ArrayList<>();
        lista.add("Pato");
        lista.add("Paco");
        lista.add("Pepe");
        lista.add("Pepa");

        Stream<String> nombresStreamlista= lista.stream();
        nombresStreamlista.forEach(System.out::println);
        lista.stream().forEach(System.out::println);

    }
}
