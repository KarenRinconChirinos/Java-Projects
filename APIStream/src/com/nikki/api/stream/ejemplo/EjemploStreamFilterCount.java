 package com.nikki.api.stream.ejemplo;

import com.nikki.api.stream.ejemplo.models.Usuario;

import java.util.stream.Stream;

 public class EjemploStreamFilterCount {
     public static void main(String[] args) {
          long count = Stream
                  .of("pato guz", "paco jam", "pepa mar", "pepe men"
                          , "pepe maer")
                  .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))// el map devuelve un resultado o el dato cambiado
                  .peek(System.out::println)
                  .count();//anymatch es operador terminal

         System.out.println(count);
     }
 }
