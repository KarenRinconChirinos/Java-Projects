 package com.nikki.api.stream.ejemplo;

import com.nikki.api.stream.ejemplo.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

 public class EjemploStreamDistinct {
     public static void main(String[] args) {
          Stream<String> nombres = Stream.of("pato guz", "paco jam", "pepa mar", "pepe men"
                          , "pepe maer", "paco jam", "paco jam", "paco jam")
                  .distinct();
          nombres.forEach(System.out::println);
     }
 }
