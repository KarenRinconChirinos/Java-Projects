 package com.nikki.api.stream.ejemplo;

import java.util.stream.Stream;

 public class EjemploStreamReduce {
     public static void main(String[] args) {
          Stream<String> nombres = Stream.of("pato guz", "paco jam", "pepa mar", "pepe men"
                          , "pepe maer", "paco jam", "paco jam", "paco jam")
                  .distinct();
          String resultado = nombres.reduce("resultado concatenado: ", (a,b) -> a + "," +b);
         System.out.println(resultado);
     }
 }
