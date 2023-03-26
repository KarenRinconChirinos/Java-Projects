 package com.nikki.api.stream.ejemplo;

import com.nikki.api.stream.ejemplo.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

 public class EjemploStreamFilterSingle2 {
     public static void main(String[] args) {
          Usuario usuario =Stream
                  .of("pato guz", "paco jam", "pepa mar", "pepe men"
                          , "pepe maer")
                  .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))// el map devuelve un resultado o el dato cambiado
                  .peek(System.out::println)
                  .filter(u -> u.getId().equals(4))
                  .findFirst().get(); //el findFirst sirve como iterador, pcuando encuentra la coincidencia deja de iterar


         System.out.println(usuario);//convertimos a un solo objeto de tipo usuario
          //peek - realizar un rastreo de los elementos
     }
 }
