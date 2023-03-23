package com.nikki.java8.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

public class EjemploFunction {
    public static void main(String[] args) {
        Function<String, String> funcion1 = param -> "Hola que tal" + param;
        String resultado = funcion1.apply("Karen");
        System.out.println(resultado);

        Function<String, String> f2 = param -> param.toUpperCase();
        System.out.println(f2.apply("Andres"));

        Function<String, String> f22 = String::toUpperCase; // parametro por defect0
        System.out.println(f2.apply("Andres"));

        BiFunction<String, String, String> f3 = (a,b) -> a.toUpperCase().concat(b.toUpperCase());
        String resultado3 =f3.apply("Maria", "Julio");
        System.out.println(resultado3);

        BiFunction<String, String, Integer> f4 = String::compareTo;//(a,b) -> a.compareTo(b);
        System.out.println(f4.apply("mar", "irlanda"));


        BiFunction<String, String, String> f5 = String::concat;//(a,b) -> a.concat(b);
        System.out.println(f4.apply("mar", "irlanda"));
    }
}
