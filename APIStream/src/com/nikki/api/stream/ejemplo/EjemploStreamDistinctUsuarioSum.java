 package com.nikki.api.stream.ejemplo;

import com.nikki.api.stream.ejemplo.models.Usuario;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

 public class EjemploStreamDistinctUsuarioSum {
     public static void main(String[] args) {
          IntStream nombres = Stream
                  .of("pato guz", "paco jam", "pepa mar", "pepe men"
                          , "pepe maer","pato guz","pato guz","pato guz")
                  .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))// el map devuelve un resultado o el dato cambiado
                  .distinct()//operador intermedio
                  .mapToInt( u -> u.getId())
                  .peek(System.out::println);

         //nombres.forEach(System.out::println);
         IntSummaryStatistics stats = nombres.summaryStatistics();
         System.out.println("total" + stats.getSum()); //siempre un operador final
         System.out.println("max" + stats.getMax());
         System.out.println("min" + stats.getMin());
         System.out.println("proemdio" + stats.getAverage());

     }
 }
