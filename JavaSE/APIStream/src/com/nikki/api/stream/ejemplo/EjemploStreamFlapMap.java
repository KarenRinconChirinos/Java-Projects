 package com.nikki.api.stream.ejemplo;

import com.nikki.api.stream.ejemplo.models.Usuario;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

 public class EjemploStreamFlapMap {
     public static void main(String[] args) {
          Stream<Usuario> nombres =Stream
                  .of("pato guz", "paco jam", "pepa mar", "pepe men"
                          , "pepe maer")
                  .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))// el map devuelve un resultado o el dato cambiado
                  .flatMap(u -> {
                      if(u.getNombre().equalsIgnoreCase("pepe")){
                          return Stream.of(u);
                      }
                      return Stream.empty();
                  })
                  .peek(System.out::println);

         System.out.println(nombres.count());
     }
 }
