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
                  .filter(u -> u.getNombre().equals("pepe"))
                  .peek(System.out::println);

         List<Usuario> lista = nombres.collect(Collectors.toList());
         lista.forEach(u -> System.out.println(u.getApellido()));
          //peek - realizar un rastreo de los elementos
     }
 }
