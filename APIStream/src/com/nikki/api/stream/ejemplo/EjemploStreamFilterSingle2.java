 package com.nikki.api.stream.ejemplo;

import com.nikki.api.stream.ejemplo.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

 public class EjemploStreamFilterSingle2 {
     public static void main(String[] args) {
          Stream<Usuario> nombres =Stream
                  .of("pato guz", "paco jam", "pepa mar", "pepe men"
                          , "pepe maer")
                  .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))// el map devuelve un resultado o el dato cambiado
                  .filter(u -> u.getNombre().equals("pepe"))
                  .peek(System.out::println);

          //objeto optional permite anidar para obtenerlo, si esta vacio, filtrarlo
         Optional<Usuario> usuario = nombres.findFirst(); //buscar el primero
         System.out.println(usuario.get());//convertimos a un solo objeto de tipo usuario
          //peek - realizar un rastreo de los elementos
     }
 }
