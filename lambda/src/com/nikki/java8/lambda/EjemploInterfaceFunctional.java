package com.nikki.java8.lambda;

import com.nikki.java8.lambda.aritmetica.Aritmetica;
import com.nikki.java8.lambda.aritmetica.Calculadora;

public class EjemploInterfaceFunctional {
    public static void main(String[] args) {
        Aritmetica suma = (a,b) -> a + b;
        Aritmetica resta = (a,b) -> a - b;

        Calculadora cal = new Calculadora();
        System.out.println(cal.computar(10,5,suma));
        System.out.println(cal.computar(10,5,resta));
        System.out.println(cal.computar(10,5,(a,b) -> a * b));
        System.out.println(cal.computarConBiFunction(10,5, (a,b) -> a + b));

    }
}
