 package com.nikki.api.stream.ejemplo;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

 public class EjemploStreamRange {
     public static void main(String[] args) {
         //rangecosed - incluyente incluye eel 20
         //range - excluyente, no incluye en 20
         //IntStream, LongStream, DoubleStream
          IntStream nombres = IntStream.range(5,20)//no toca el 20
                  .peek(System.out::println);

         //reduce (valor inicia, expresion lambda)
         //int resultado = nombres.reduce(0, (a,b) -> a +  b);
         //int resultado = nombres.reduce(0, (a,b) -> Integer.sum(a,b));
         //int resultado = nombres.reduce(0, Integer::sum);
         int resultado = nombres.sum();
         IntSummaryStatistics stats = nombres.summaryStatistics();
         System.out.println("max " + stats.getMax());
         System.out.println("min " + stats.getMin());
         System.out.println("sum " + stats.getSum());
         System.out.println("promedio " + stats.getAverage());
         System.out.println("total " + stats.getCount());
     }
 }
