package com.nikki.api.stream.ejeplo;

import java.util.function.IntToDoubleFunction;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EjemploStreamModificarflujoyDevolverSum {
    public static void main(String[] args) {
        /*Como desafió consiste en un arreglo de 100 elementos del
        1 al 100, del tipo int, utilizando el api stream se pide
        eliminar los divisibles en 10, luego convertir los elementos
         restante del flujo en tipo double y dividirlos en 2, para
         finalmente devolver la suma total de todos ellos usando el
         operador terminal reduce. El resultado debería ser
        */
        IntStream numeros = IntStream.range(1, 101)
                .filter(n -> {
                   if(n % 10 == 0){
                       return false;
                    }
                    return true;
                });
        //numeros.mapToDouble(n -> n/2);
        double num = numeros.reduce(0, (a,b) -> (a + b));
        System.out.println("Suma total: " + num/2);

        double nume = IntStream.rangeClosed(1, 100)
                .filter(n -> n%10 != 0)
                .peek(System.out::println)
                .mapToDouble(d -> d)
                .flatMap(d -> DoubleStream.of(d/2))
                .reduce(0,Double::sum);

        System.out.println("Resultado = " + num);
    }
}
