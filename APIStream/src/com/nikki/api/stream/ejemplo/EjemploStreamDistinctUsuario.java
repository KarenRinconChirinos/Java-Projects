 package com.nikki.api.stream.ejemplo;

import com.nikki.api.stream.ejemplo.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

 public class EjemploStreamDistinctUsuario {
     public static void main(String[] args) {
          Stream<Usuario> nombres =Stream
                  .of("pato guz", "paco jam", "pepa mar", "pepe men"
                          , "pepe maer","pato guz","pato guz","pato guz")
                  .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))// el map devuelve un resultado o el dato cambiado
                  .distinct();//operador intermedio

         nombres.forEach(System.out::println);
     }
 }
